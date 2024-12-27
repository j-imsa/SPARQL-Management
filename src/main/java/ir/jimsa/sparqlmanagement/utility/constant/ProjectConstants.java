package ir.jimsa.sparqlmanagement.utility.constant;

public class ProjectConstants {

    // ======================== PUBLIC ID ======================== //
    public static final int PUBLIC_ID_MIN_LENGTH = 32;
    public static final int PUBLIC_ID_MAX_LENGTH = 512;
    public static final int PUBLIC_ID_DEFAULT_LENGTH = 64;
    public static final String PUBLIC_ID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    // ======================== Exception ======================== //
    public static final String EXCEPTION_PUBLIC_ID_MESSAGE = "SPARQL Public ID is invalid!";
    public static final String EXCEPTION_NOT_FOUND_RESOURCE_MESSAGE = "The resource with provided public_id not founded!";


}
