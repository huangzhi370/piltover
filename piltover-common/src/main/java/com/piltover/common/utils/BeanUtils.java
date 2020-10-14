package com.piltover.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;


/**
 * 名称：BeanUtils <br>
 * 描述：<br>
 *
 * author Alex
 * 
 * @version 1.0
 * @since 1.0.0
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {

	private static final Log logger = LogFactory.getLog(BeanUtils.class);

	/**
	 * 默认忽略字段<br>
	 */
	private static String[] IGNORE_PROPERTIES = { "createUser", "createTime" };

	/**
	 * 重写copyProperties，NULL值,可以拷贝 增加默认忽略字段 modify by zhangguoqing at
	 * 2017年4月8日16:13:55
	 *
	 * @param source 拷贝元实体
	 * @param target 拷贝目标实体
	 * @throws BeansException 抛出异常
	 */
	public static void copyProperties1(Object source, Object target, String[] ignoreList) throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		List<String> ignorePropertyList = new ArrayList<String>();
		ignorePropertyList.addAll(Arrays.asList(IGNORE_PROPERTIES));
		// 传入的忽略数组非空扩展忽略数组
		if (ignoreList != null && ignoreList.length != 0) {
			ignorePropertyList.addAll(Arrays.asList(ignoreList));
		}
		Class<?> actualEditable = target.getClass();
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());

				if (sourcePd != null && sourcePd.getReadMethod() != null
						&& !ignorePropertyList.contains(targetPd.getName())) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						// 这里判断value是否为空,过滤Integer类型字段 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
						// if (value != null &&
						// !"java.lang.Integer".equals(readMethod.getReturnType().getName())) {
						// if (value != null && !"".equals(value)) {
						Method writeMethod = targetPd.getWriteMethod();
						if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
							writeMethod.setAccessible(true);
						}
						writeMethod.invoke(target, value);
						// }
					} catch (Throwable ex) {
						throw new FatalBeanException(
								"Could not copy properties '" + targetPd.getName() + "' from source to target", ex);
					}
				}
			}
		}
	}

	/**
	 * 重写copyProperties，忽略NULL值
	 *
	 * @param source
	 * @param target
	 * @throws BeansException
	 */
	public static void copyProperties(Object source, Object target) throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");
		Class<?> actualEditable = target.getClass();
		PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null) {
				PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object value = readMethod.invoke(source);
						// 这里判断value是否为空,过滤Integer类型字段 当然这里也能进行一些特殊要求的处理 例如绑定时格式转换等等
//                        if (value != null && !"java.lang.Integer".equals(readMethod.getReturnType().getName())) {
						if (value != null) {
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, value);
						}
					} catch (Throwable ex) {
						throw new FatalBeanException(
								"Could not copy properties '" + targetPd.getName() + "' from source to target", ex);
					}
				}
			}
		}
	}

	/**
	 * bean 转为map
	 *
	 * @param obj         bean对象
	 * @param isAllowNull 空字段是否转换 false 不转换
	 * @return map值
	 */
	public static Map<String, Object> bean2Map(Object obj, boolean isAllowNull) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);
					if (isAllowNull || value != null && !value.toString().isEmpty()) {
						map.put(key, value);
					}
				}
			}
		} catch (Exception e) {
			logger.error("实体转Map出错:[" + e + "]");
		}
		return map;
	}

	/**
	 * bean 转为map
	 *
	 * @param obj         bean对象
	 * @param isAllowNull 空字段是否转换 false 不转换
	 * @return map值
	 */
	public static Map<String, String> bean2TreeMap(Object obj, boolean isAllowNull) {
		if (obj == null) {
			return null;
		}
		Map<String, String> map = new TreeMap<String, String>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (!key.equals("class")) {
					Method getter = property.getReadMethod();
					String value = (String) getter.invoke(obj);
					if (isAllowNull || value != null && !value.toString().isEmpty()) {
						map.put(key, value);
					}
				}
			}
		} catch (Exception e) {
			logger.error("实体转TreeMap出错:[" + e + "]");
		}
		return map;
	}

	/**
	 * map转bean
	 *
	 * @param targetMap 被转化的map
	 * @param obj       对象
	 * @throws Exception 
	 */
	public static void map2Bean(Map<String, Object> targetMap, Object obj) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		for (String key : targetMap.keySet()) {
			Object value = targetMap.get(key);
			map.put(StringUtils.lineToHump(key), value);
		}
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				if (map.containsKey(key)) {
					try {
						Object value = map.get(key);
						// 得到property对应的setter方法
						Method setter = property.getWriteMethod();
						setter.invoke(obj, value);
					} catch (Exception e) {
						throw new Exception("实体转换错误:" + key);
					}
				}

			}
		} catch (Exception e) {
			throw new Exception("数据转换异常！");
		}
	}
	public static void mapToUser(Map<String, String> targetMap, Object obj) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		for (String key : targetMap.keySet()) {
			String value = targetMap.get(key);
			map.put(StringUtils.lineToHump(key), value);
		}
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				
				if (map.containsKey(key)) {
					try {
						Object value = map.get(key);
						// 得到property对应的setter方法
						Method setter = property.getWriteMethod();
						setter.invoke(obj, value);
					} catch (Exception e) {
						throw new Exception("实体转换错误:" + key);
					}
				}
				
			}
		} catch (Exception e) {
			throw new Exception("数据转换异常！");
		}
	}
	
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {    
        if (map == null)  
            return null;  
  
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        Object obj = beanClass.newInstance();  
  
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);  
  
        return obj;  
    }   
	
	public static <T> List<T> ListMap2JavaBean(List<Map<String, String>> datas, Class<T> beanClass){
		 List<T> list = null;
		 list = new ArrayList<T>();
		 
		// 创建一个泛型类型实例  
         try {
			for (Map<String, String> map : datas) {
				T t = beanClass.newInstance();
				org.apache.commons.beanutils.BeanUtils.populate(t, map);  
				list.add(t);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
         return list;
	}
	
	/**
	   * 将Map中的key由下划线转换为驼峰
	   *
	   * @param map
	   * @return
	   */
	  public static Map<String, Object> formatHumpName(Map<String, Object> map) {
	    Map<String, Object> newMap = new HashMap<String, Object>();
	    Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
	    while (it.hasNext()) {
	      Map.Entry<String, Object> entry = it.next();
	      String key = entry.getKey();
	      String newKey = toFormatCol(key);
	      newMap.put(newKey, entry.getValue());
	    }
	    return newMap;
	  }
	  
	  public static String toFormatCol(String colName) {
		    StringBuilder sb = new StringBuilder();
		    String[] str = colName.toLowerCase().split("_");
		    int i = 0;
		    for (String s : str) {
		      if (s.length() == 1) {
		        s = s.toUpperCase();
		      }
		      i++;
		      if (i == 1) {
		        sb.append(s);
		        continue;
		      }
		      if (s.length() > 0) {
		        sb.append(s.substring(0, 1).toUpperCase());
		        sb.append(s.substring(1));
		      }
		    }
		    return sb.toString();
		  }
	  
	  /**
	   * 将List中map的key值命名方式格式化为驼峰
	   *
	   * @param
	   * @return
	   */
	  public static List<Map<String, Object>> formatHumpNameForList(List<Map<String, Object>> list) {
	    List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
	    for (Map<String, Object> o : list) {
	      newList.add(formatHumpName(o));
	    }
	    return newList;
	  }
	  
    public static List<Object> beanValueToList(Object obj){
	    if(obj==null) {
	    	return null;
	    }
	    try {
			List<Object> list = new ArrayList<>();
			Field[] fields=obj.getClass().getDeclaredFields();
			for(int i=0;i<fields.length;i++){
			    String fieldName = fields[i].getName();
			    if(!"serialVersionUID".equals(fieldName) && !"orderTypeId".endsWith(fieldName)) {
			    	 String getter  = "get" + fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
					 Method method = obj.getClass().getMethod(getter, new Class[] {});
					 Object value = method.invoke(obj, new Object[] {});
					 if(value==null) {
					    value = "";
					 }
					 list.add(value);
			    }
			}
			return list;
		} catch (Exception e) {
			return null;
		} 
    }
    
    public static <T> List<Map<String,Object>> listConvert(List<T> list){
        List<Map<String,Object>> list_map=new ArrayList<Map<String,Object>>();
        try {
            for (T t : list) {
                Field[] fields=t.getClass().getDeclaredFields();
                Map<String, Object> m = new HashMap<String, Object>();
                for(Field field:fields){
                    String keyName=field.getName();
                    PropertyDescriptor pd = new PropertyDescriptor(keyName,t.getClass());
                    Method getMethod = pd.getReadMethod();// 获得getter方法
                    Object o = getMethod.invoke(t);// 执行get方法返回一个Object
                    m.put(keyName, o);
                }
                list_map.add(m);
            }
            return list_map;
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return null;
    }
}
