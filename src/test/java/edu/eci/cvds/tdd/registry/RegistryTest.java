package edu.eci.cvds.tdd.registry;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;



/**
 * 
 * @author 
 * Clases de equivalencia:
 * 1. La persona que se desea registrar está muerta.
 * 	El atributo de persona alive representa si la persona está viva o muerta.
 * 2. La persona que se deses registrar es menor de edad
 *  El atributo age representa a una persona menor de edad.
 * 3. La persona que se desea registrar tiene una edad invalida registrada en el sistema.
 * 	El atributo age representa a una persona menor de edad.
 * 4. La persona que se desea registrar ya votó
 * 	El atributo id de la persona indica si esta ya realizó su voto.
 * 5. La persona que se desea cumple con los requisitos
 * 	Los atributos de la persona cumplen las condiciones.
 */


public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateAlive() {
    	
    	Person person = new Person("person",1234,25,Gender.MALE,false);
    	
    	RegisterResult result = registry.registerVoter(person);
    	
    	Person person2 = new Person("person2",1235,25,Gender.MALE,true);
    	
    	RegisterResult result2 = registry.registerVoter(person2);
    	
    	assertEquals(RegisterResult.DEAD, result);
    	assertEquals(RegisterResult.VALID, result2);
    	
    }
    
    @Test
    public void validateUnderage() {
    	
    	Person person = new Person("person",1234,0,Gender.MALE,true);
    	Person person2 = new Person("person",1236,10,Gender.MALE,true);
    	Person person3 = new Person("person",1237,17,Gender.MALE,true);
    	
    	RegisterResult result = registry.registerVoter(person);
    	RegisterResult result2 = registry.registerVoter(person2);
    	RegisterResult result3 = registry.registerVoter(person3);
    	
    	assertEquals(RegisterResult.UNDERAGE, result);
    	assertEquals(RegisterResult.UNDERAGE, result2);
    	assertEquals(RegisterResult.UNDERAGE, result3);
    	
    }
    
    @Test
    public void validateInvalidateAge() {
    	Person person = new Person("person",1239,-5,Gender.MALE,true);
    	Person person2 = new Person("person",1238,109,Gender.MALE,true);
    	Person person3 = new Person("person",12312,120,Gender.MALE,true);
    	
    	RegisterResult result = registry.registerVoter(person);
    	RegisterResult result2 = registry.registerVoter(person2);
    	RegisterResult result3 = registry.registerVoter(person3);
    	
    	assertEquals(RegisterResult.INVALID_AGE, result);
    	assertEquals(RegisterResult.VALID, result2);
    	assertEquals(RegisterResult.INVALID_AGE, result3);
    	
    }
    
    @Test
    public void validateDuplicate() {
    	Person person = new Person("person",2345,30,Gender.MALE,true);
    	Person person2 = new Person("person",2345,30,Gender.MALE,true);
    	
    	RegisterResult result = registry.registerVoter(person);
    	RegisterResult result2 = registry.registerVoter(person2);
    	
    	assertEquals(RegisterResult.VALID, result);
    	assertEquals(RegisterResult.DUPLICATED, result2);
    }
 
    @Test
    public void validateRegistryResult() {

    	Person person = new Person("person",5555,18,Gender.FEMALE,true);
    	Person person2 = new Person("person",5556,90,Gender.MALE,true);
    	Person person3 = new Person("person",5558,105,Gender.UNIDENTIFIED,true);
    	
    	RegisterResult result = registry.registerVoter(person);
    	RegisterResult result2 = registry.registerVoter(person2);
    	RegisterResult result3 = registry.registerVoter(person3);
    	
    	assertEquals(RegisterResult.VALID, result);
    	assertEquals(RegisterResult.VALID, result2);
    	assertEquals(RegisterResult.VALID, result3);
    	
    }

    // TODO Complete with more test cases
}