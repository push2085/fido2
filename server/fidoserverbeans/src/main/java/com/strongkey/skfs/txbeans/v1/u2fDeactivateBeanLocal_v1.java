/**
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License, as published by the Free Software Foundation and
 * available at http://www.fsf.org/licensing/licenses/lgpl.html,
 * version 2.1 or above.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * Copyright (c) 2001-2018 StrongAuth, Inc.
 *
 * $Date$
 * $Revision$
 * $Author$
 * $URL$
 *
 * *********************************************
 *                    888
 *                    888
 *                    888
 *  88888b.   .d88b.  888888  .d88b.  .d8888b
 *  888 "88b d88""88b 888    d8P  Y8b 88K
 *  888  888 888  888 888    88888888 "Y8888b.
 *  888  888 Y88..88P Y88b.  Y8b.          X88
 *  888  888  "Y88P"   "Y888  "Y8888   88888P'
 *
 * *********************************************
 *
 * Local interface for u2fDeactivateBean
 *
 */
package com.strongkey.skfs.txbeans.v1;

import com.strongkey.skfs.utilities.SKCEReturnObject;
import javax.ejb.Local;

/**
 * Local interface for u2fDeactivateBean
 *
 */
@Local
public interface u2fDeactivateBeanLocal_v1 {

    /**
     * This method is responsible for deactivating the user registered key from
     * the persistent storage. This method first checks if the given ramdom id
     * is mapped in memory to the specified user and if found yes, gets the
     * registration key id and then changes the key status to INACTIVE in the
     * database.
     *
     * Additionally, if the key being deactivated is the last one for the user,
     * the ldap attribute of the user called 'FIDOKeysEnabled' is set to 'no'.
     *
     * @param did - FIDO domain id
     * @param protocol - U2F protocol version to comply with.
     * @param username - username
     * @param randomid - random id that is unique to one fido registered
     * authenticator for the user.
     * @param modifyloc - Geographic location from where the activation is
     * happening
     * @return - returns SKCEReturnObject in both error and success cases. In
     * error case, an error key and error msg would be populated In success
     * case, a simple msg saying that the process was successful would be
     * populated.
     */
    SKCEReturnObject execute(String did,
            String protocol,
            String username,
            String randomid,
            String modifyloc);
}
