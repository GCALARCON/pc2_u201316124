/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.multas.controllers;

import com.mycompany.multas.entidades.Multas;
//import com.mycompany.multas.entidades.Marca;
//import com.mycompany.multas.entidades.Modelo;
import com.mycompany.multas.persistence.JPAUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author josediaz
 */
@ManagedBean
@ViewScoped
public class MultaBean implements Serializable {

    static final long serialVersionUID = -8780407253943723401L;
    private Multas multa;
    private List<Multas> multas;
    private Contribuyente contribuyente; // util para buscar los modelos (combo en cascada)

    @PostConstruct
    public void init() {
        multa = new Multas();
    }

    public Multas getMultas() {
        return multa;
    }

    public void setMultas(Multas multas) {
        this.multa = multas;
    }

    public String grabar(Multas auto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.persist(auto);

        JPAUtil.evictCache(em, Multas.LISTAR_DESTACADOS);

        FacesMessage msg = new FacesMessage("Multa grabado con exito!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        return "listar";
    }

    public void buscarMultas(Tributo tributo) {

        String jpql = "select a from Multas a where 1=1";
        Map<String, Object> params = new HashMap<>();
        if (tributo.getContribuyente() != null) {
            jpql += " and a.contribuyente.tributo = :tributo";
            params.put("tributo", contribuyente.gettributo());
        }
        if (contribuyente.getDescripcion()!= null && !contribuyente.getDescripcion().isEmpty()) {
            jpql += " and a.modelo.descripcion like :descripcion";
            params.put("descripcion", "%" + contribuyente.getDescripcion()+ "%");
        }

        TypedQuery<Multas> query = JPAUtil.getEntityManager().createQuery(jpql, Multas.class);
        for (Map.Entry<String, Object> param : params.entrySet()) {

            query.setParameter(param.getKey(), param.getValue());
        }

        multa = (Multas) query.getResultList();

    }

    public List<Multas> getMulta() {
        if (multa == null) {
            multa = (Multas) JPAUtil.getEntityManager().
                    createNamedQuery(Multas.LISTAR_DESTACADOS, Multas.class).getResultList();
        }

        return (List<Multas>) multa;
    }

//    public Marca getMarca() {
//        return marca;
//    }

//    public void setMarca(Marca marca) {
//        this.marca = marca;
//    }
}
