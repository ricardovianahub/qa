package com.aa.fakeresponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FakeresponseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FakeresponseApplication.class, args);
    }

    @GetMapping(value = "/")
    public String root() {
        return "root 002";
    }

    private static class CreatePNRResponse {
        private String recordLocator = "BLAH";

        public CreatePNRResponse(String recordLocator) {
            this.recordLocator = recordLocator;
        }

        public String getRecordLocator() {
            return recordLocator;
        }

        public CreatePNRResponse setRecordLocator(String recordLocator) {
            this.recordLocator = recordLocator;
            return this;
        }
    }

    @GetMapping(value = "/monitor")
    public String monitor() {
        return "Monitor responding from the backend at " + new Date();
    }

    @GetMapping(value = "/version")
    public String monitor2() {
        return "Version 2 - responding from the backend at " + new Date();
    }

    @PostMapping(value = "/createpnr", produces = MediaType.APPLICATION_JSON_VALUE)
    public CreatePNRResponse createPNRResponse() {
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append((char) ('A' + rnd.nextInt(26)));
        }
        return new CreatePNRResponse(stringBuilder.toString());
    }

    @GetMapping(value = "/three", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Data3> three() {
        List<Data3> data3List = new ArrayList<>();
        data3List.add(new Data3("ORDDFW", "ORD", "Mrs", "DFW", "555-1234", "sdfgs ert3John Doe", "John Doe"));
        data3List.add(new Data3("ORDDFW", "ORD", "Mrs", "DFW", "555-1234", "sdsdfJohn Doe", "John Doe"));
        data3List.add(new Data3("ORDDFW", "ORD", "Mrs", "DFW", "555-1234", "John Doe", "John Doe"));
        data3List.add(new Data3("ORDDFW", "ORD", "Mrs", "DFW", "555-1234", "rtuJane Doe", "Jane Doe"));
        data3List.add(new Data3("ORDDFW", "ORD", "Mrs", "DFW", "555-1234", "srr tusrJohn Doe", "John Doe"));
        data3List.add(new Data3("DFWLAX", "DFW", "Mr", "LAX", "555-1234", "rtyrttyJohn Doe", "John Doe"));
        data3List.add(new Data3("LAXYYZ", "LAX", "Miss", "YYZ", "555-1234", "gggggJohn Doe", "John Doe"));
        data3List.add(new Data3("LAXYYZ", "LAX", "Miss", "YYZ", "555-1234", "dfgdfgJohn Doe", "John Doe"));
        data3List.add(new Data3("LAXYYZ", "LAX", "Miss", "YYZ", "555-1234", "John Doe", "John Doe"));
        data3List.add(new Data3("LAXYYZ", "LAX", "Miss", "YYZ", "555-1234", "d fgdgdfgJohn Doe", "John Doe"));
        data3List.add(new Data3("LAXYYZ", "LAX", "Miss", "YYZ", "555-1234", "sJohn Doe", "John Doe"));

        return data3List;
    }

    @GetMapping(value = "/passengers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataPassengers> passengers() {
        List<DataPassengers> data3List = new ArrayList<>();
        data3List.add(new DataPassengers("John", "Doe", "LAX", "DAL"));
        data3List.add(new DataPassengers("James", "Doe", "DFW", "DAL"));
        data3List.add(new DataPassengers("Julia", "Doe", "YYZ", "DAL"));
        data3List.add(new DataPassengers("Jennifer", "Doe", "DAL", "DAL"));
        data3List.add(new DataPassengers("Jimes", "Doe", "DFW", "DAL"));
        data3List.add(new DataPassengers("Jannifer", "Doe", "DAL", "DAL"));
        data3List.add(new DataPassengers("Jomes", "Doe", "DFW", "DAL"));
        data3List.add(new DataPassengers("Jinnifer", "Doe", "DAL", "DAL"));
        data3List.add(new DataPassengers("Jumes", "Doe", "DFW", "DAL"));
        data3List.add(new DataPassengers("Jonnifer", "Doe", "DAL", "DAL"));
        data3List.add(new DataPassengers("Jymes", "Doe", "DFW", "DAL"));
        data3List.add(new DataPassengers("Joanna", "Doe", "ORD", "ORD"));
        data3List.add(new DataPassengers("Jezebel", "Doe", "YYZ", "YYZ"));
        data3List.add(new DataPassengers("Jillian", "Doe", "LAX", "LAX"));
        data3List.add(new DataPassengers("Julian", "Doe", "GRU", "GRU"));

        return data3List;
    }

    @GetMapping(value = "/airport/{airportCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AirportResponse> airport(@PathVariable String airportCode) {
        return new ArrayList<>() {
            {
                add(new AirportResponse().setZip(airportZipCodes.get(airportCode)));
            }
        };
    }

    @GetMapping(value = "/multiplication/{number}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String multiplication(@PathVariable String number) {
        return String.valueOf(Integer.parseInt(number) * 2);
    }

    @GetMapping(value = "/addition/{number1}/{number2}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String multiplication(@PathVariable String number1, @PathVariable String number2) {
        return String.valueOf(Integer.parseInt(number1) + Integer.parseInt(number2));
    }

    @GetMapping(value = "/dash/{text1}/{text2}/{text3}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String dash(@PathVariable String text1, @PathVariable String text2, @PathVariable String text3) {
        return text1 + "-" + text2 + "-" + text3;
    }

    @GetMapping(value = "/one", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Data1> one() {
        List<Data1> data1List = new ArrayList<>();
        data1List.add(new Data2("Alice", "Doe", 21, "Mrs"));
        data1List.add(new Data2("John", "Doe", 30, "Mr"));
        data1List.add(new Data2("Jane", "Doe", 28, "Miss"));
        data1List.add(new Data2("Alan", "Smithee", 25, "N/A"));
        data1List.add(new Data2("Bob", "Smithee", 24, "N/A"));
        data1List.add(new Data2("Joe", "Smithee", 25, "N/A"));
        data1List.add(new Data2("Joe", "Schmo", 22, "Mr"));
        data1List.add(new Data2("Julia", "Schmo", 26, "Miss"));
        data1List.add(new Data2("Bob", "Slob", 27, "Mr"));
        data1List.add(new Data2("NEW", "NEW", 99, "N/A"));
        data1List.add(new Data2("No", "Way", 44, "N/A"));
        data1List.add(new Data2("Sergio", "David", 24, "N/A"));
        data1List.add(new Data2("Ricardo", "Test04", 16, "Mr"));

        return data1List;
    }

    public static class Data2 extends Data1 {

        private String salutation;
        private String carrier;

        public Data2(String firstName, String lastName, int age) {
            super(firstName, lastName, age);
            this.salutation = "n/a";
            this.carrier = "AA";
        }

        public Data2(String firstName, String lastName, int age, String salutation) {
            super(firstName, lastName, age);
            this.salutation = salutation;
            this.carrier = "AA";
        }

        public String getSalutation() {
            return salutation;
        }

        public String getCarrier() {
            return carrier;
        }
    }

    public static class DataPassengers {
        private String firstName;
        private String lastName;
        private String origination;
        private String residence;

        public DataPassengers(String firstName, String lastName, String origination, String residence) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.origination = origination;
            this.residence = residence;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getOrigination() {
            return origination;
        }

        public String getResidence() {
            return residence;
        }
    }

    public static class Data1 {
        private String firstName;
        private String lastName;
        private int age;

        public Data1(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public Data1 setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Data1 setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Data1 setAge(int age) {
            this.age = age;
            return this;
        }
    }

    public static class Data3 {
        private String itinerary;
        private String origin;
        private String date;
        private String destination;
        private String phone;
        private String ssr;
        private String name;

        public Data3(String itinerary, String origin, String date, String destination, String phone, String ssr, String name) {
            this.itinerary = itinerary;
            this.origin = origin;
            this.date = date;
            this.destination = destination;
            this.phone = phone;
            this.ssr = ssr;
            this.name = name;
        }

        public String getItinerary() {
            return itinerary;
        }

        public Data3 setItinerary(String itinerary) {
            this.itinerary = itinerary;
            return this;
        }

        public String getOrigin() {
            return origin;
        }

        public Data3 setOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public String getDate() {
            return date;
        }

        public Data3 setDate(String date) {
            this.date = date;
            return this;
        }

        public String getDestination() {
            return destination;
        }

        public Data3 setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public String getPhone() {
            return phone;
        }

        public Data3 setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public String getSsr() {
            return ssr;
        }

        public Data3 setSsr(String ssr) {
            this.ssr = ssr;
            return this;
        }

        public String getName() {
            return name;
        }

        public Data3 setName(String name) {
            this.name = name;
            return this;
        }
    }

    private Map<String, String> airportZipCodes = new HashMap<>() {{
        put("DFW", "17732");
        put("DAL", "17732");
        put("ORD", "15504");
        put("YYZ", "13302");
        put("LAX", "13301");
        put("GRU", "13300");
        put("JFK", "75006");
    }};

    private class AirportResponse {
        private String zip;

        public String getZip() {
            return zip;
        }

        public AirportResponse setZip(String zip) {
            this.zip = zip;
            return this;
        }
    }
}
