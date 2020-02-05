package edu.eci.cvds.tdd.aerodescuentos;
import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;



/**
 * 
 * @author 
 * Clases de equivalencia:
 * 1 Valor base del vuelo sea valido 	Correcto: entero positivo incorrecto: entero negative o decimales 
 * 2 Número de días valido inferior a 20	Correcto: entero positivo y sin descuento Incorrecto: entero negative o decimales
 * 3 Edad entre 18 y 65	Correcto: entero positivo y sin descuento Incorrecto: entero negativo o decimales 
 * 4 Edad superior a 65	Correcto: 8% de descuento
 * 5 Edad inferior a 18	Correcto: 5% de descuento
 * 6 Numero de de días superior a 20 días	Correcto: 15% de descuento

 */


public class TarifasTest{

    private CalculadorDescuentos calculadora = new CalculadorDescuentos();

    @Test
    public void validateClase1() {
    	
    	
    	long var1=(long) calculadora.calculoTarifa(150,19,25);
		assertEquals((long) (150), var1);
		try {
			long var2=(long) calculadora.calculoTarifa(-5,50,25);
		} catch (Exception e) {
			assertTrue(e.getMessage()!=null);
		}
		
    	
    }
	
	@Test
	public void validateClase2(){
		long var1=(long) calculadora.calculoTarifa(20,18,25);   
    	assertEquals((long) (20), var1);
		long var2=(long) calculadora.calculoTarifa(20,21,25);   
    	assertEquals((long) (20*0.85), var2);
		
	}
	@Test
	public void validateClase3(){
		long var1=(long) calculadora.calculoTarifa(20,18,19);   
    	assertEquals((long) (20), var1);
		long var2=(long) calculadora.calculoTarifa(20,11,64);   
    	assertEquals((long) (20), var2);
	}
	@Test
	public void validateClase4(){
		long var1=(long) calculadora.calculoTarifa(20,18,70);   
    	assertEquals((long) (20*0.92), var1);
		long var2=(long) calculadora.calculoTarifa(20,11,65);   
    	assertEquals((long) (20), var2);
	}
	@Test
	public void validateClase5(){
		long var1=(long) calculadora.calculoTarifa(20,19,11);   
    	assertEquals((long) (20*0.95), var1);
		long var2=(long) calculadora.calculoTarifa(20,18,25);   
    	assertEquals((long) (20), var2);
	}
	@Test
	public void validateClase6(){
		long var1=(long) calculadora.calculoTarifa(20,50,25);   
    	assertEquals((long) (20*0.85), var1);
		long var2=(long) calculadora.calculoTarifa(20,19,25);   
    	assertEquals((long) (20), var2);
	}

    
   

    // TODO Complete with more test cases
}