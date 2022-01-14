package sv.gob.mined.projects.sgipd.repositories.exceptions;

import javax.persistence.PersistenceException;

public class SGIPDPersistenceException extends PersistenceException {
    public static final int DELETE=0;
    public static final String DELETE_MSG="Could not delete the entity: $type";
    public static final int SAVE=1;
    public static final String SAVE_MSG="Could not save the entity: $type";
    public static final int UPDATE=2;
    public static final String UPDATE_MSG="Could not update the entity: $type";
    public static final int RETRIEVE=3;
    public static final String RETRIEVE_MSG="Could not RETRIEVE the entity or entities: $type";
    public static final int UNKNOWN=4;
    public static final String UNKNOWN_MSG="Unknown Error on entity: $type";
    private Class entityClass;
    private int operation;
    public SGIPDPersistenceException() {
        super();
    }

    public SGIPDPersistenceException(String message) {
        super(message);
    }

    public SGIPDPersistenceException(Class entityClass, int operation) {
        super("");
        this.entityClass = entityClass;
        this.operation = operation;


    }

    private String replaceMessage(String MSG, Class type){
        return MSG.replaceFirst("\\$type",type.getName());
    }

    public String createMessage(){
        if(operation==DELETE){
            return replaceMessage(DELETE_MSG,entityClass);
        }else if(operation==SAVE){
            return replaceMessage(SAVE_MSG,entityClass);
        }else if(operation==UPDATE){
            return replaceMessage(UPDATE_MSG,entityClass);
        }else if(operation==RETRIEVE){
            return replaceMessage(RETRIEVE_MSG,entityClass);
        }else{
            return replaceMessage(UNKNOWN_MSG,entityClass);
        }
    }
}
