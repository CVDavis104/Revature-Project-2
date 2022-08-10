package com.project.EcommerceSpringBoot.utils;

import com.project.EcommerceSpringBoot.models.ClientMessage;

public class ClientMessageUtil {

    public static final ClientMessage CREATION_SUCCESSFUL = new ClientMessage("REGISTRATION SUCCESSFUL");
    public static final ClientMessage CREATION_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING CREATION");
    public static final ClientMessage UPDATE_SUCCESSFUL = new ClientMessage("UPDATE SUCCESSFUL");
    public static final ClientMessage UPDATE_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING UPDATE");
    public static final ClientMessage DELETION_SUCCESSFUL = new ClientMessage("DELETION SUCCESSFUL");
    public static final ClientMessage DELETION_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING DELETION");
    public static final ClientMessage LOGIN_SUCCESSFUL = new ClientMessage("LOGIN SUCCESSFUL");
    public static final ClientMessage LOGIN_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING LOGIN");
    public static final ClientMessage RETRIEVAL_SUCCESSFUL = new ClientMessage("RETRIEVAL SUCCESSFUL");
    public static final ClientMessage RETRIEVAL_FAILED = new ClientMessage("SOMETHING WENT WRONG DURING RETRIEVAL");

}/*ClientMessageUtil class ending*/
