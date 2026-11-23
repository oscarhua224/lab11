package ejercicio4.command;


import ejercicio4.modelo.Producto;
import ejercicio4.modelo.ProcesadorCompras;

import java.util.List;

public class RealizarCompraCommand implements Comando {

    private ProcesadorCompras procesador;
    private List<Producto> productos;

    public RealizarCompraCommand(
            ProcesadorCompras procesador,
            List<Producto> productos) {

        this.procesador = procesador;
        this.productos = productos;
    }

    @Override
    public void ejecutar() {
        procesador.procesarCompra(productos);
    }
}