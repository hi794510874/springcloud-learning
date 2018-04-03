package com.owen.mapper;

import com.owen.model.PkgSalesOrderMasterEntity;

public interface PkgSalesOrderMasterEntityMapper {
    int deleteByPrimaryKey(Integer salesorderno);

    int insert(PkgSalesOrderMasterEntity record);

    int insertSelective(PkgSalesOrderMasterEntity record);

    PkgSalesOrderMasterEntity selectByPrimaryKey(Integer salesorderno);

    int updateByPrimaryKeySelective(PkgSalesOrderMasterEntity record);

    int updateByPrimaryKey(PkgSalesOrderMasterEntity record);
}