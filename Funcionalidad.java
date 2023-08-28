//package Utilidades;

/**
 * Esta clase es utilizada para almacenar funcionalidad Java común en otras clases
 * a la que se puede acceder mediante forma estática.
 * 
 * Funcionalidad sto_:
 * a) stoA : String to Array <separator> [TODO]
 * b) stoB : String to Boolean
 *    stob : String to Bytes [TODO]
 * c) ? [TODO]
 * d) stoD : String to Double
 * e) ? [TODO]
 * f) stoF : String to Float
 * g) ? [TODO]
 * h) stoH : String to HTML [TODO]
 * i) stoI : String to Integer
 * j) stoC : String to JSON [TODO]
 * k) ? [TODO]
 * l) stoL : String to List [TODO]
 * m) stoM : String to Map [TODO]
 * n) stoN : String to Node [TODO]
 * o) stoO : String to Object [TODO]
 * p) stoP : String to Predicate [TODO]
 * q) stoQ : String to Query [TODO]
 * r) ? [TODO]
 * s) ? [TODO]
 * t) stoT : String to Type <type> [TODO]
 * u) stoU : String to Unicode [TODO]
 * v) stoV : String to Vector [TODO]
 * w) stoW : String to Word [TODO]
 * x) stoX : String to Xml [TODO]
 * y) ? [TODO]
 * z) ? [TODO]
 * 
 * @author drakopablo.dev
 */
public abstract class Funcionalidad {  
    
    /**
     * Método para transformar String a Integer
     * 
     * @param String _integer
     * @return Integer
     */
    public static Integer stoI(String _integer) {
        Integer result = null;
        try {
            result = Integer.parseInt(_integer);
        } catch (Exception e) {
            // Nada
        }
        return result;
    }
    
    /**
     * Método para transformar String a Boolean
     * 
     * @param String _boolean
     * @return Boolean
     */
    public static Boolean stoB(String _boolean) {
        Boolean result = null;
        try {
            result = Boolean.parseBoolean(_boolean);
        } catch (Exception e) {
            // Nada
        }
        return result;
    }
        
    /**
     * Método para transformar String a Double
     * 
     * @param String _double
     * @return Double
     */
    public static Double stoD(String _double) {
        Double result = null;
        try {
            result = Double.parseDouble(_double);
        } catch (Exception e) {
            // Nada
        }
        return result;
    }
    
    /**
     * Método para transformar String a Float
     * 
     * @param String _double
     * @return Double
     */
    public static Float stoF(String _float) {
        Float result = null;
        try {
            result = Float.parseFloat(_float);
        } catch (Exception e) {
            // Nada
        }
        return result;
    }
    
    /**
     * Método para redondear un Double con "decimals" decimales
     * 
     * @param Double _double
     * @return Double
     */
    public static Double round(Double _double, int decimals) {        
        Double result = null;
        try {
            int power10 = (int) Math.pow(10, decimals);
            result = (double) Math.round(_double * power10) / power10;
        } catch (Exception e) {
            // Nada
        }
        return result;
    }
    
    /**
     * Método para redondear un Float con "decimals" decimales
     * 
     * @param Float _float
     * @return Float
     */
    public static Float round(Float _float, int decimals) {        
        Float result = null;
        try {
            int power10 = (int) Math.pow(10, decimals);
            result = (float) Math.round(_float * power10) / power10;
        } catch (Exception e) {
            // Nada
        }
        return result;
    }
}
