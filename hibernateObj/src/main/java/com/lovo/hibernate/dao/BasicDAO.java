package com.lovo.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;


@Component
public class BasicDAO <T,ID extends Serializable>{
    Class<T> tclass; //泛型的类型
    public BasicDAO(){
    tclass=    ReflectUtils.getClassGenricType(this.getClass());
    }
    //注入hibernate工厂bean
    @Autowired
    private LocalSessionFactoryBean factoryBean;

    /**
     * 没有被spring管理的session
     * @return
     */
    public Session getOpenSession(){
      return   factoryBean.getObject().openSession();
    }

    /**
     * 被spring管理的session
     * @return
     */
    public Session getCurrentSession(){
        return  factoryBean.getObject().getCurrentSession();
    }

    /**
     * 保持对象
     * @param t
     */
     public  void savaObj(T t){
        this.getCurrentSession().save(t);
     }

     public void delObjById(ID id){
      this.getCurrentSession().delete(this.getCurrentSession().get(tclass,id));

     }

     //查询所有
    public List<T> getAll(){
         return  getCurrentSession().createQuery("from "+tclass.getSimpleName()).list();
    }

    //带条件的查询
    public List<T> getListParam(String hql,Object[] objects){

       Query query= getCurrentSession().createQuery(hql);

        //代表有条件查询
        if(null!=objects&&objects.length>0){
            //设置条件
          for(int i=0;i<objects.length;i++){
            query.setParameter(i,objects[i]);
          }
        }

       return query.list();
    }


}
