package ir.jimsa.sparqlmanagement.utility.constant;

public class ProjectConstants {

    // ======================== Application ======================== //
    public static final String APP_VERSION = "v0.0.1";

    // ======================== PUBLIC ID ======================== //
    public static final int PUBLIC_ID_MIN_LENGTH = 32;
    public static final int PUBLIC_ID_MAX_LENGTH = 512;
    public static final int PUBLIC_ID_DEFAULT_LENGTH = 64;
    public static final String PUBLIC_ID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    // ======================== Exception ======================== //
    public static final String EXCEPTION_PUBLIC_ID_MESSAGE = "SPARQL Public ID is invalid!";
    public static final String EXCEPTION_NOT_FOUND_RESOURCE_MESSAGE = "The resource with provided public_id not founded!";

    // ======================== API Definition ======================== //
    public static final String API_DOCUMENT_INFO_TITLE = "SPARQL Management Document Information";
    public static final String API_DOCUMENT_INFO_DESCRIPTION = "SPARQL microservice REST API documentation";
    public static final String API_DOCUMENT_INFO_VERSION = APP_VERSION;
    public static final String API_DOCUMENT_INFO_CONTACT_NAME = "Iman Salehi";
    public static final String API_DOCUMENT_INFO_CONTACT_URL = "https://www.linkedin.com/in/jimsa/";
    public static final String API_DOCUMENT_INFO_CONTACT_EMAIL = "cse.isalehi@gmail.com";
    public static final String API_DOCUMENT_INFO_LICENSE_NAME = "Apache 2.0";
    public static final String API_DOCUMENT_INFO_LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";
    public static final String API_DOCUMENT_EXTERNAL_DOCS_DESCRIPTION = "Source code repository";
    public static final String API_DOCUMENT_EXTERNAL_DOCS_URL = "https://github.com/j-imsa/SPARQL-Management";
    public static final String API_DOCUMENT_SERVERS_1_DESCRIPTION = "Dev, local";
    public static final String API_DOCUMENT_SERVERS_1_URL = "http://localhost:8085/";
    public static final String API_DOCUMENT_SERVERS_2_DESCRIPTION = "Dev, Server";
    public static final String API_DOCUMENT_SERVERS_2_URL = "http://152.11.42.185:8090/";
}
