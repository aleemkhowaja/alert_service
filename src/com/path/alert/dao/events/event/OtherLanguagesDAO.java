package com.path.alert.dao.events.event;

import java.util.List;

import com.path.alert.vo.events.event.OtherLanguagesCO;
import com.path.alert.vo.events.event.OtherLanguagesSC;
import com.path.lib.common.exception.DAOException;

public interface OtherLanguagesDAO
{
    /**
     * Fetch count of records in table
     * @param otherLanguagesSC
     * @return int
     * @throws DAOException
     */
    public int returnOtherLanguagesListCount(OtherLanguagesSC otherLanguagesSC) throws DAOException;
    
    /**
     * Fetch other languages list
     * @param otherLanguagesSC
     * @return List
     * @throws DAOException
     */
    public List<OtherLanguagesCO> returnOtherLanguagesListRec(OtherLanguagesSC otherLanguagesSC) throws DAOException;
    

}
