package com.owen.mapper;

import com.owen.model.PkgOrderMasterANDSalesOrderMasterEntity;

import java.util.List;

/**
 * Created by huang_b on 2018/4/3.
 */
public interface PkgOrderMasterANDSalesOrderMasterEntityMapper {
    List<PkgOrderMasterANDSalesOrderMasterEntity> selectByPkgOrderNo(String pkgorderno);
}
