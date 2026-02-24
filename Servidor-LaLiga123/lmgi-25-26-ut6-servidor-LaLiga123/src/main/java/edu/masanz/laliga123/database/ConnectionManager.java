package edu.masanz.laliga123.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {

    private static Connection conexion;

    public static boolean conectar(String bd, String usuario, String contrasena){
        boolean exito = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection( "jdbc:mysql://localhost/" + bd, usuario, contrasena ) ;
            conexion.setAutoCommit(true);
            exito = true;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error en la conexión con la BBDD. "+e);
        }
        return exito;
    }

    public static Object[][] ejecutarSelectSQL(String sql, Object[] params) {
        Object[][] resultado = null;
        try {
            if(conexion!=null && !conexion.isClosed()) {
                PreparedStatement pst = conexion.prepareStatement(sql);
                establecerParametros(pst, params);
                ResultSet rs = pst.executeQuery();
                resultado = convertirResultSets(rs);
                rs.close();
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public static int ejecutarUpdateSQL(String sql, Object[] params) {
        int registrosAfectados = -1;
        try {
            if(conexion!=null && !conexion.isClosed()) {
                PreparedStatement pst = conexion.prepareStatement(sql);
                establecerParametros(pst, params);
                registrosAfectados = pst.executeUpdate();
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfectados;
    }

    // Sólo mysql, para otras BBDD mirar cómo obtener la clave generada.
    public static long ejecutarInsertSQL(String sql, Object[] params) {
        int registrosAfectados = -1;
        try {
            if(conexion!=null && !conexion.isClosed()) {
                PreparedStatement pst = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                establecerParametros(pst, params);
                registrosAfectados = pst.executeUpdate();
                if (registrosAfectados > 0) {
                    ResultSet rs = pst.getGeneratedKeys();
                    rs.next();
                    Long id = rs.getLong(1);
                    rs.close();
                    pst.close();
                    return id;
                }
                pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    private static Object[][] convertirResultSets(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }
        List<Object[]> filas = new ArrayList<>();
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            Object[] fila = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            filas.add(fila);
        }
        return filas.toArray(new Object[0][0]);
    }

    private static void establecerParametros(PreparedStatement pst, Object[] params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                if (params[i] != null) {
                    if (params[i] instanceof String) {
                        pst.setString(i + 1, (String) params[i]);
                    } else if (params[i] instanceof Integer) {
                        pst.setInt(i + 1, (Integer) params[i]);
                    } else if (params[i] instanceof Double) {
                        pst.setDouble(i + 1, (Double) params[i]);
                    } else if (params[i] instanceof Float) {
                        pst.setFloat(i + 1, (Float) params[i]);
                    } else if (params[i] instanceof java.util.Date) {
                        Date sqlDate = new Date(((java.util.Date) params[i]).getTime());
                        pst.setDate(i + 1, sqlDate);
                    } else {
                        pst.setObject(i + 1, params[i]);
                    }
                } else {
                    pst.setNull(i + 1, Types.NULL);
                }
            }
        }
    }

    public static boolean desconectar(){
        boolean exito = false;
        try {
            if(conexion!=null && !conexion.isClosed()){
                conexion.close();
                exito = true;
            }
        } catch (SQLException e) {
            System.out.println("Error desconectando con la BBDD. "+e);
        }
        return exito;
    }

}
