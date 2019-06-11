package com.bazzar.DAO;

import java.util.List;

import com.bazzar.model.Supplier;

public interface SupplierDao 
{
   public boolean addsupplier(Supplier supplier);
   public boolean deletesupplier(Supplier supplier);
   public boolean updatesupplier(Supplier supplier);
   public Supplier getSupplier(int supplierId);
   public List<Supplier> listSupplier();
}
