package com.owen.mapper;

import com.owen.model.PkgOrderMasterEntity;

public interface PkgOrderMasterEntityMapper {
    int deleteByPrimaryKey(String pkgorderno);

    int insert(PkgOrderMasterEntity record);

    int insertSelective(PkgOrderMasterEntity record);

    PkgOrderMasterEntity selectByPrimaryKey(String pkgorderno);

    int updateByPrimaryKeySelective(PkgOrderMasterEntity record);

    int updateByPrimaryKey(PkgOrderMasterEntity record);
}