package es.ull.passengers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import es.ull.flights.Flight;

public class PassengersTest {

	@DisplayName("Tests para pasajeros")
	@Nested
	class PassengersCommonTests {

	    private Flight vueloFuerteventura;
	    private Flight vueloLanzarote;
	    private Passenger miguel;
	    private Passenger jaime;
	    private Passenger susana;
	    private Passenger laura;

	    @BeforeEach
	    void setUp() {
	    	vueloFuerteventura = new Flight("FV001", 100);
	    	vueloLanzarote = new Flight("LZ001", 82);
	    	miguel = new Passenger("id-PS01-1","Miguel", "ES");
	    	jaime = new Passenger("id-PS02-1","Jaime", "GE");
	    	susana = new Passenger("id-PS02-2","Susana", "US");
	    	laura= new Passenger("id-PS01-2","Laura", "IT");
	    }

	        @Test
	        @DisplayName("Comprobación de atributos")
	        void testParametersPassenger() {

	        	laura.setFlight(vueloLanzarote);

	            assertAll("Verifica todas las condiciones un intercambio a través de joinFlight",
	                    () -> assertEquals("id-PS01-2", laura.getIdentifier()),
	                    () -> assertEquals("Miguel", miguel.getName()),
	                    () -> assertEquals("GE", jaime.getCountryCode()),
	                    () -> assertEquals(null, susana.getFlight()),
	                    () -> {
	                    	susana.setFlight(vueloFuerteventura);
	                    	assertEquals("FV001", susana.getFlight().getFlightNumber());
	                    },
	                    () -> assertEquals("Passenger Laura with identifier: id-PS01-2 from IT", laura.toString())
	            );
	        }
	}
}
