package org.example.ejercicios;

import java.util.*;

public class Metodos {

    /**
     * Metodo que suma numeros impares
     *
     * @param array coleccion de numeros de loc cuales solo se suma los impares
     * @return suma de numero impares
     */
    public int sumarImpares(int[] array) {
        int suma = 0;
        for (int num : array) {
            if (num % 2 != 0) {
                suma += num;
            }
        }
        return suma;
    }

    // Ejercicio clasico de FizzBuzz
    public List<String> fizzBuzz() {
        List<String> resultado = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                resultado.add("FizzBuzz");
            } else if (i % 3 == 0) {
                resultado.add("Fizz");
            } else if (i % 5 == 0) {
                resultado.add("Buzz");
            } else {
                resultado.add(String.valueOf(i));
            }
        }
        return resultado;
    }

    // metodo que busca el primer caracter no repetido
    public char primerNoRepetido(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : input.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '-';
    }

    // Metodo para contar palabras de un String
    public Map<String, Integer> contarPalabras(String input) {
        Map<String, Integer> map = new HashMap<>();
        String[] palabras = input.split(" ");
        for (String palabra : palabras) {
            map.put(palabra, map.getOrDefault(palabra, 0) + 1);
        }
        /*for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/
        return map;
    }

    // Metodo para agrupar por longitud con computeifAbsent
    public Map<Integer, List<String>> agruparPorLongitud(List<String> lista) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String palabra : lista) {
            int longitud = palabra.length();
            map.computeIfAbsent(longitud, k -> new ArrayList<>()).add(palabra);
        }
        return map;
    }

    // Metodo para agrupar por longitud con constainskey
    public Map<Integer, List<String>> agruparPorLongitud2(List<String> lista) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String palabra : lista) {
            int longitud = palabra.length();

            if (!map.containsKey(longitud)) {
                map.put(longitud, new ArrayList<>()); // si no existe, agregamos una nueva lista
            }

            map.get(longitud).add(palabra); // ahora sí agregamos la palabra a la lista

        }
        return map;
    }

    // Agrupar anagramas con containsKey
    public Map<String, List<String>> agruparAnagramas(List<String> lista) {
        Map<String, List<String>> map = new HashMap<>();

        for (String palabra : lista) {
            char[] letras = palabra.toCharArray();
            Arrays.sort(letras);
            String clave = new String(letras);
            if (!map.containsKey(clave)) {
                map.put(clave, new ArrayList<>());
            }
            map.get(clave).add(palabra);

        }

        return map;

    }

    // Agrupar anagramas con computeIfAbsent
    public Map<String, List<String>> agruparPorAnagramas2(List<String> lista) {
        Map<String, List<String>> map = new HashMap<>();
        for (String palabra : lista) {
            char[] letras = palabra.toCharArray();
            Arrays.sort(letras);
            String clave = new String(letras);

            map.computeIfAbsent(clave, k -> new ArrayList<>()).add(palabra);
        }
        return map;
    }

    // Metodo para agrupar lista de palabras por primer caracter
    public Map<Character, List<String>> agruparPorPrimerCaracter(List<String> lista) {
        Map<Character, List<String>> mapa = new HashMap<>();

        for (String palabra : lista) {
            char caracter = Character.toLowerCase(palabra.charAt(0));

            mapa.computeIfAbsent(caracter, k -> new ArrayList<>()).add(palabra);
        }
        return mapa;

    }

    // Metodo para calcular precios por productos
    public Map<String, Double> calcularGastosPorProductos(List<Compra> compras) {
        Map<String, Double> mapa = new HashMap<>();
        for (Compra compra : compras) {
            mapa.merge(compra.getNombre(), compra.getPrecio(), Double::sum);
        }
        return mapa;
    }

    // Metodo para calcular monto por Producto con "contaniskey"
    public Map<String, Double> calcularMontoPorProductos(List<Compra> compras) {
        Map<String, Double> mapa = new HashMap<>();
        for (Compra compra : compras) {
            String producto = compra.getNombre();
            double precio = compra.getPrecio();

            if (mapa.containsKey(producto)) {
                double totalActual = mapa.get(producto);
                mapa.put(producto, totalActual + precio);
            } else {
                mapa.put(producto, precio);
            }
        }
        return mapa;
    }


/*    public Map<String, List<String>> agruparPorRangoEdad(List<Usuario> usuarios) {
        Map<String, List<String>> mapa = new HashMap<>();

        for (Usuario usuario : usuarios) {
            int edad = usuario.getEdad();
            String nombre = usuario.getNombre();
            if (edad < 18) {
                mapa.computeIfAbsent("Menor", k -> new ArrayList<>()).add(nombre);
            } else if (edad <= 60) {
                mapa.computeIfAbsent("Adulto", k -> new ArrayList<>()).add(nombre);
            } else {
                mapa.computeIfAbsent("Mayor", k -> new ArrayList<>()).add(nombre);
            }
        }
        return mapa;
    }*/

/*    public Map<String, String> obtenerUsuarioMasJovenPorUsuario(List<Usuario> usuarios) {
        Map<String, Usuario> mapaTemporal = new HashMap<>();

        for (Usuario usuario : usuarios) {

            String ciudad = usuario.getCiudad();
            if (!mapaTemporal.containsKey(ciudad) || usuario.getEdad() < mapaTemporal.get(ciudad).getEdad()) {
                mapaTemporal.put(ciudad, usuario);
            }
        }

        Map<String, String> resultadoFinal = new HashMap<>();

        for (Map.Entry<String, Usuario> entry : mapaTemporal.entrySet()) {
            resultadoFinal.put(entry.getKey(), entry.getValue().getNombre());
        }


        return resultadoFinal;
    }*/

    public Map<String, Boolean> verificarDuplicadosPorCurso(List<Estudiante> estudiantes) {
        Map<String, Set<String>> nombresPorCurso = new HashMap<>();
        Map<String, Boolean> resultado = new HashMap<>();

        for (Estudiante estudiante : estudiantes) {
            String nombre = estudiante.getNombre();
            String curso = estudiante.getCurso();

            nombresPorCurso.computeIfAbsent(curso, k -> new HashSet<>());

            if (nombresPorCurso.get(curso).contains(nombre)) {
                resultado.put(curso, true);
            } else {
                nombresPorCurso.get(curso).add(nombre);

                resultado.put(curso, false);
            }
        }
        return resultado;
    }


    // Problemas del dia 1

    public Map<Character, List<String>> agruparPorPrimeraLetra(List<String> palabras) {
        Map<Character, List<String>> mapa = new HashMap<>();
        for (String palabra : palabras) {
            char caracter = Character.toLowerCase(palabra.charAt(0));

            mapa.computeIfAbsent(caracter, k -> new ArrayList<>()).add(palabra);
        }
        return mapa;
    }

    public Map<Character, List<String>> agruparPorPrimerCaracteres(List<String> palabras) {
        Map<Character, List<String>> mapa = new HashMap<>();
        for (String palabra : palabras) {
            char caracter = Character.toLowerCase(palabra.charAt(0));
            if (!mapa.containsKey(caracter)) {
                mapa.put(caracter, new ArrayList<>());
            }
            mapa.get(caracter).add(palabra);
        }
        return mapa;
    }

    // Agrupar Por ciudad

    public Map<String, List<String>> agruparPorCiudad(List<Usuario> usuarios) {
        Map<String, List<String>> mapaTemporal = new HashMap<>();
        for (Usuario usuario : usuarios) {
            // String ciudad = usuario.getCiudad();
            mapaTemporal.computeIfAbsent(usuario.getCiudad(), k -> new ArrayList<>()).add(usuario.getNombre());
        }
        return mapaTemporal;
    }

    public Map<String, List<String>> agruparUsuPorCiudad(List<Usuario> usuarios) {
        Map<String, List<String>> mapaTemporal = new HashMap<>();
        for (Usuario usuario : usuarios) {
            String ciudad = usuario.getCiudad();
            if (!mapaTemporal.containsKey(ciudad)) {
                mapaTemporal.put(ciudad, new ArrayList<>());
            }
            mapaTemporal.get(ciudad).add(usuario.getNombre());
        }
        return mapaTemporal;
    }

    // Agrupar Por Categoria

    public Map<String, List<String>> agruparPorCategorias(List<Producto> productos) {
        Map<String, List<String>> map = new HashMap<>();
        for (Producto producto : productos) {
            map.computeIfAbsent(producto.getTipo(), k -> new ArrayList<>()).add(producto.getNombre());
        }
        return map;
    }

    // Ejercicios dia 2

    public Map<String, Integer> contarPalabrasTexto(String texto) {
        Map<String, Integer> mapa = new HashMap<>();
        String[] palabras = texto.split(" ");
        for (String palabra : palabras) {
            int contar = mapa.getOrDefault(palabra, 0);
            mapa.put(palabra, contar + 1);
            //mapa.merge(palabra, 1, Integer::sum);
        }
        return mapa;
    }

    //contar usuarios por ciudad
    public Map<String, Integer> contarUsuariosPorCiudadCorrespondiente(List<Usuario> usuarios) {
        Map<String, Integer> mapaTemporal = new HashMap<>();
        for (Usuario usuario : usuarios) {
            mapaTemporal.merge(usuario.getCiudad(), 1, Integer::sum);

        }
        return mapaTemporal;
    }

    // contar productos por categorias
    public Map<String, Integer> contarProductoPorCategorias(List<Producto> productos) {
        Map<String, Integer> mapaTemporal = new HashMap<>();
        for (Producto producto : productos) {
            mapaTemporal.merge(producto.getTipo(), 1, Integer::sum);
        }
        return mapaTemporal;

    }

    // Agrupar por ciudad
    public Map<String, Set<String>> agruparNombresUnicosPorCiudad(List<Usuario> usuarios) {
        Map<String, Set<String>> mapaTemporal = new HashMap<>();
        for (Usuario usuario : usuarios) {
            mapaTemporal
                    .computeIfAbsent(usuario.getCiudad(), k -> new HashSet<>())
                    .add(usuario.getNombre());
        }
        return mapaTemporal;
    }

    public Map<String, Set<String>> agruparCategoriasPorProducto(List<Producto> productos) {
        Map<String, Set<String>> mapaTemporal = new HashMap<>();
        for (Producto producto : productos) {
            mapaTemporal
                    .computeIfAbsent(producto.getNombre(), k -> new HashSet<>())
                    .add(producto.getTipo());
        }
        return mapaTemporal;
    }

    public Map<String, Set<String>> agruparProductosPorCategoria(List<Producto> productos) {
        Map<String, Set<String>> mapaTemporal = new HashMap<>();
        for (Producto producto : productos) {
            mapaTemporal
                    .computeIfAbsent(producto.getTipo(), k -> new HashSet<>())
                    .add(producto.getNombre());
        }
        return mapaTemporal;
    }

    // Dia 4

    // Calcular promedio por tipo de producto
    public Map<String, Double> calcularPrecioPromedioPorTipo(List<Producto> productos) {
        Map<String, Double> resultado = new HashMap<>();
        Map<String, List<Double>> precios = new HashMap<>();
        for (Producto producto : productos) {
            precios
                    .computeIfAbsent(producto.getTipo(), k -> new ArrayList<>())
                    .add(producto.getPrecio());
        }


        for (Map.Entry<String, List<Double>> entry : precios.entrySet()) {
            String tipo = entry.getKey();
            List<Double> precio = entry.getValue();

            double suma = 0;
            for (double p : precio) {
                suma += p;
            }
            double promedio = suma / precio.size();
            resultado.put(tipo, promedio);

        }

        return resultado;
    }

    public Map<String, Double> calcularPromedioEdadPorCiudad(List<Usuario> usuarios) {
        Map<String, double[]> acumulador = new HashMap<>();

        for (Usuario usuario : usuarios) {
            acumulador
                    .computeIfAbsent(usuario.getCiudad(), k -> new double[2]);
            double[] datos = acumulador.get(usuario.getCiudad());
            datos[0] += usuario.getEdad();
            datos[1] += 1;
        }

        Map<String, Double> resultado = new HashMap<>();
        for (Map.Entry<String, double[]> entry : acumulador.entrySet()) {
            String ciudad = entry.getKey();
            double[] datos = entry.getValue();
            double promedio = datos[0] / datos[1];
            resultado.put(ciudad, promedio);
        }
        return resultado;
    }
    public Map<String, Set<String>> agruparNombresUnicosPorCiudades(List<Usuario> usuarios){
        Map<String, Set<String>> mapaTemporal = new HashMap<>();
        for(Usuario usuario : usuarios){
            mapaTemporal
                    .computeIfAbsent(usuario.getCiudad(), k -> new HashSet<>())
                    .add(usuario.getNombre());
        }
        return mapaTemporal;
    }

    public Map<Integer, Set<String>> agruparPalabrasUnicasPorLongitud(List<String> palabras){
        Map<Integer, Set<String>> mapaTemporal = new HashMap<>();
        for (String palabra : palabras) {
            int longitud = palabra.length();
            mapaTemporal
                    .computeIfAbsent(longitud, k -> new HashSet<>())
                    .add(palabra);
        }
        return mapaTemporal;
    }


    public Map<String, List<String>> agruparNombresPorTipoConPrecioMayorA50(List<Producto> productos){
        Map<String, List<String>> mapaTemporal = new HashMap<>();
        for (Producto producto : productos) {
            double precio = producto.getPrecio();

            if (precio>50){
                mapaTemporal
                        .computeIfAbsent(producto.getTipo(), k -> new ArrayList<>())
                        .add(producto.getNombre());
            }

        }
        return mapaTemporal;
    }

}

