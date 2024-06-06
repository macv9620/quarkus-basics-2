package com.macv.controller;

import com.macv.entity.ProductEntity;
import com.macv.service.IProductService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/products")
public class ProductController {

    private final IProductService productService;

    @Inject
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response
                .status(Response.Status.OK)
                .entity(productService.getAll())
                .build();
    }

    @GET
    @Path("/{id}")
    @Transactional
    public Response getById(@PathParam("id") Long id){
        return Response
                .status(Response.Status.OK)
                .entity(productService.findById(id))
                .build();
    }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(ProductEntity productEntity){
        return Response
                .status(Response.Status.CREATED)
                .entity(productService.create(productEntity))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteById(@PathParam("id") Long id){
        productService.deleteById(id);
    }

}
