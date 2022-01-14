package sv.gob.mined.projects.sgipd.utils;

import org.jboss.logging.Logger;
import sv.gob.mined.projects.sgipd.entities.DocenteResumen;
import sv.gob.mined.projects.sgipd.entities.NuevosDatosExpediente;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class XClassUtil {
    private static Logger logger = Logger.getLogger(XClassUtil.class);

    public static String getGetterName(String basePropertyName, Integer indiceExperiencia){
        return "get"+basePropertyName.substring(0, 1).toUpperCase()
                + basePropertyName.substring(1)+indiceExperiencia;
    }

    public static String getSetterName(String basePropertyName, String indiceCriterio){
        return "set"+basePropertyName.substring(0, 1).toUpperCase()
                + basePropertyName.substring(1)+indiceCriterio;
    }

    public static void setBigDecimalByNombreAndIndiceCriterio(final DocenteResumen r ,
                                                   String basePropertyName,
                                                   String indiceCriterio, BigDecimal value){

        String setterName = getSetterName(basePropertyName,indiceCriterio);
        try{
            Method m  = DocenteResumen.class.getMethod(setterName, BigDecimal.class);
            m.invoke(r,value);
        }catch (Exception e){
            logger.error("Error reading property: "+basePropertyName
                    +" for indice: "+indiceCriterio,e);
        }
    }

    public static Timestamp getFechaByNombreAndIndice(NuevosDatosExpediente p ,
                                                      String basePropertyName,
                                                      Integer indiceExperiencia){
        Timestamp value = null;
        String getterName = getGetterName(basePropertyName,indiceExperiencia);
        try{
            Method m  = NuevosDatosExpediente.class.getMethod(getterName);
            value = (Timestamp) m.invoke(p);
        }catch (Exception e){
            logger.error("Error reading property: "+basePropertyName
                    +" for indice: "+indiceExperiencia,e);
        }
        return value;
    }

    public static Boolean getBooleanByNombreAndIndice(NuevosDatosExpediente p ,
                                                      String basePropertyName,
                                                      Integer indiceExperiencia){
        Boolean value = null;
        String getterName = getGetterName(basePropertyName,indiceExperiencia);
        try{
            Method m  = NuevosDatosExpediente.class.getMethod(getterName);
            value = (Boolean) m.invoke(p);
        }catch (Exception e){
            logger.error("Error reading property: "+basePropertyName
                    +" for indice: "+indiceExperiencia,e);
        }
        return value;
    }

    public static String getStringByNombreAndIndice(NuevosDatosExpediente p ,
                                                      String basePropertyName,
                                                      Integer indiceExperiencia){
        String value = null;
        String getterName = getGetterName(basePropertyName,indiceExperiencia);
        try{
            Method m  = NuevosDatosExpediente.class.getMethod(getterName);
            value = (String) m.invoke(p);
        }catch (Exception e){
            logger.error("Error reading property: "+basePropertyName
                    +" for indice: "+indiceExperiencia,e);
        }
        return value;
    }

    public static Integer getIntegerByNombreAndIndice(NuevosDatosExpediente p ,
                                                    String basePropertyName,
                                                    Integer indiceExperiencia){
        Integer value = null;
        String getterName = getGetterName(basePropertyName,indiceExperiencia);
        try{
            Method m  = NuevosDatosExpediente.class.getMethod(getterName);
            value = (Integer) m.invoke(p);
        }catch (Exception e){
            logger.error("Error reading property: "+basePropertyName
                    +" for indice: "+indiceExperiencia,e);
        }
        return value;
    }

    public static Long getLongByNombreAndIndice(NuevosDatosExpediente p ,
                                                      String basePropertyName,
                                                      Integer indiceExperiencia){
        Long value = null;
        String getterName = getGetterName(basePropertyName,indiceExperiencia);
        try{
            Method m  = NuevosDatosExpediente.class.getMethod(getterName);
            value = (Long) m.invoke(p);
        }catch (Exception e){
            logger.error("Error reading property: "+basePropertyName
                    +" for indice: "+indiceExperiencia,e);
        }
        return value;
    }

    public static Timestamp getFechaByNombreAndIndiceOE(NuevosDatosExpediente p ,
                                                      String basePropertyName,
                                                      Integer indiceExperiencia){
        Timestamp value = null;
        String getterName = getGetterName(basePropertyName,indiceExperiencia-4);
        try{
            Method m  = NuevosDatosExpediente.class.getMethod(getterName);
            value = (Timestamp) m.invoke(p);
        }catch (Exception e){
            logger.error("Error reading property: "+basePropertyName
                    +" for indice: "+indiceExperiencia,e);
        }
        return value;
    }

    public static Boolean getBooleanByNombreAndIndiceOE(NuevosDatosExpediente p ,
                                                      String basePropertyName,
                                                      Integer indiceExperiencia){
        Boolean value = null;
        String getterName = getGetterName(basePropertyName,indiceExperiencia-4);
        try{
            Method m  = NuevosDatosExpediente.class.getMethod(getterName);
            value = (Boolean) m.invoke(p);
        }catch (Exception e){
            logger.error("Error reading property: "+basePropertyName
                    +" for indice: "+indiceExperiencia,e);
        }
        return value;
    }

    public static String getStringByNombreAndIndiceOE(NuevosDatosExpediente p ,
                                                    String basePropertyName,
                                                    Integer indiceExperiencia){
        String value = null;
        String getterName = getGetterName(basePropertyName,indiceExperiencia-4);
        try{
            Method m  = NuevosDatosExpediente.class.getMethod(getterName);
            value = (String) m.invoke(p);
        }catch (Exception e){
            logger.error("Error reading property: "+basePropertyName
                    +" for indice: "+indiceExperiencia,e);
        }
        return value;
    }

}
