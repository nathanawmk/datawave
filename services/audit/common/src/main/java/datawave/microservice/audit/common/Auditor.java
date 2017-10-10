package datawave.microservice.audit.common;

public interface Auditor {
    
    enum AuditType {
        NONE, LOCALONLY, PASSIVE, ACTIVE
    };
    
    String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    
    /**
     *
     * @param msg
     *            parameters for the audit message
     * @throws Exception
     */
    void audit(AuditParameters msg) throws Exception;
    
}
