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
 * l) stoL : String to Long [TODO]
 * ll) stoLL : String to List [TODO]
 * m) stoM : String to Map [TODO]
 * n) stoN : String to Node [TODO]
 * o) stoO : String to Object [TODO]
 * p) stoP : String to Predicate [TODO]
 * q) stoQ : String to Query [TODO]
 * r) ? [TODO]
 * s) stoS : String to Set [TODO]
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
    /////////////
    ///// B /////
    /////////////
    
    /**
     * Método para transformar String a Boolean
     * 
     * @param String _boolean
     * @return Boolean or null
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
     * Método para transformar String a Boolean, a modo coalesce
     * 
     * @param String _boolean
     * @param int _default
     * @return Boolean or _default
     */    
    public static Boolean stoB(String _boolean, boolean _default) {
        Boolean result = null;
        try {
            result = Boolean.parseBoolean(_boolean);
        } catch (Exception e) {
            result = _default;
        }
        return result;
    }
    
    /////////////
    ///// D /////
    /////////////
    
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
     * Método para transformar String a Double, a modo coalesce
     * 
     * @param String _double
     * @param double _default
     * @return Double or _default
     */
    public static Double stoD(String _double, double _default) {
        Double result = null;
        try {
            result = Double.parseDouble(_double);
        } catch (Exception e) {
            result = _default;
        }
        return result;
    }
    
    /////////////
    ///// F /////
    /////////////
    
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
     * Método para transformar String a Float, a modo coalesce
     * 
     * @param String _float
     * @param double _default
     * @return Float or _default
     */
    public static Double stoF(String _float, double _default) {
        Double result = null;
        try {
            result = Double.parseDouble(_float);
        } catch (Exception e) {
            result = _default;
        }
        return result;
    }
    
    /////////////
    ///// I /////
    /////////////
    
    /**
     * Método para transformar String a Integer
     * 
     * @param String _integer
     * @return Integer or null
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
     * Método para transformar String a Integer, a modo coalesce
     * 
     * @param String _integer
     * @param int _default
     * @return Integer or _default
     */
    public static Integer stoI(String _integer, int _default) {
        Integer result = null;
        try {
            result = Integer.parseInt(_integer);
        } catch (Exception e) {
            result = _default;
        }
        return result;
    }
    
    /////////////
    ///// * /////
    /////////////
    
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
