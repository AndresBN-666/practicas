package org.example.gestionDePublicaciones.Repository;

import org.example.connection.DatabaseConnection;
import org.example.gestionDePublicaciones.model.Libro;
import org.example.gestionDePublicaciones.model.Publication;
import org.example.gestionDePublicaciones.model.Revista;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPublicationRepository implements PublicationRepository{


    @Override
    public void agregar(Publication p) {
        String sql =  "INSERT INTO publicaciones (titulo, autor, fecha_publicacion, tipo, numero_paginas, numero_revista, editorial)" +
                "VALUES (?,?,?,?,?,?,?)";

        System.out.println(p.getTitulo());
        System.out.println(p.tipo());

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getAutor());
            ps.setDate(3, Date.valueOf(p.getFechaPublicacion()));
            ps.setString(4,p.tipo());

            if (p instanceof Libro libro) {
                ps.setInt(5, libro.getNumeroPaginas());
                ps.setNull(6, Types.INTEGER);
                ps.setNull(7, Types.VARCHAR);
            } else if (p instanceof Revista revista) {
                ps.setNull(5, Types.INTEGER);
                ps.setInt(6, revista.getNumero());
                ps.setString(7, revista.getEditorial());
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Publication> obtenerTodas() {
        List<Publication> publicaciones = new ArrayList<>();

        String sql =  "SELECT * FROM publicaciones";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery())
        {
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                LocalDate fecha = rs.getDate("fecha_publicacion").toLocalDate();
                String tipo = rs.getString("tipo");
                if ("libro".equalsIgnoreCase(tipo)) {
                    int paginas = rs.getInt("numero_paginas");
                    publicaciones.add(new Libro(titulo, autor, fecha, paginas));
                } else if ("revista".equalsIgnoreCase(tipo)) {
                    int numero = rs.getInt("numero_paginas"); // Asumiendo que este campo lo usas para número
                    String editorial = rs.getString("editorial");
                    publicaciones.add(new Revista(titulo, autor, fecha, numero, editorial));
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return publicaciones;
    }
}
