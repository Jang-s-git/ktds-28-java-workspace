package com.ktdsuniversity.edu.fp.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ktdsuniversity.edu.fp.objects.City;
import com.ktdsuniversity.edu.fp.objects.CityList;

public class Cities {

	// 1. 모든 도시의 이름만 출력해본다.
	public static void printCityName(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.map(city -> city.getCountryName()) // String
				.forEach(System.out::println); // void
		;
	}
	
	// 2. countryName이 "SouthKorea"인 데이터의 Native를 중복없이 출력해본다.
	public static void printSouthKoreaNative(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.filter(city -> city.getCountryName().equals("South Korea")) // Stream<City>
				.map(nativeStr -> nativeStr.getNativeStr()) // String
				.distinct() // String
				.forEach(System.out::println); // void
		;
	}
	
	// 3. 모든 도시의 population을 출력해본다.
	public static void printCityPopulation(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.map(city -> city.getPopulation()) // Integer
				.forEach(System.out::println); // void
		;
	}
	
	// 4. 모든 도시의 population을 출력해본다. 단, 0 이상만 출력한다.
	public static void printCityPopulationUpperZero(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.filter(city -> city.getPopulation() > 0) // Stream<City>
				.map(city -> city.getPopulation()) // Integer
				.forEach(System.out::println); // void
		;
	}
	
	// 5. countryName이 "A"로 시작하는 국가의 도시들의 TimeZone을 중복없이 출력해본다.
	public static void printTimeZone(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.filter(city -> city.getCountryName().startsWith("A")) // Stream<City>
				.map(city -> city.getTimezone()) // String
				.distinct() // Stream<String>
				.forEach(System.out::println); // void
		;
	}
	
	// 6. countryId가 10 이상인 국가들의 도시명을 출력해본다.
	public static void printCityNameUpperTen(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.filter(city -> city.getCountryId() > 10) // Stream<City>
				.map(city -> city.getName()) // String
				.forEach(System.out::println); // void
		;
	}
	
	// 7. countryName이 "South Korea"인 도시의 population 총 합을 출력해본다.
	public static void printSouthKoreaPopulation(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		int sum = cityList.filter(city -> city.getCountryName().equals("South Korea")) // Stream<City>
				.filter(city -> city.getPopulation() > 0) // Stream<City>
				.map(city -> city.getPopulation()) // Integer
				.mapToInt(city -> city) // IntStream
				.sum() // int
		;
		System.out.println(sum);
	}
	
	// 8. population 기준으로 내림차순 정렬해 10개 도시의 이름과 population을 출력해본다.
	public static void printPopulationUptoTen(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.collect(Collectors.toList()) // List<Integer>
				.stream() // Stream<City>
				.sorted((c1, c2) -> c2.getPopulation() - c1.getPopulation()) // Stream<City>
				.map(city -> city.getPopulation()) // Integer
				.limit(10) // Stream<Integer>
				.forEach(System.out::println); // void
		;
	}
	
	// 9. type이 "special self-governing province" 인 도시의 이름과 countryName을 출력해본다.
	public static void printCountryNameType(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.filter(city -> city.getType().equals("special self-governing province")) // Stream<City>
				.map(city -> city.getName()) // String
				.forEach(System.out::println); // void
		;
	}
	
	// 10. 모든 도시들을 id 별로 오름차순 정렬해 출력해본다.
	public static void printCityId(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.sequential()
				.sorted((c1, c2) -> c1.getId() - c2.getId())
				.forEach(System.out::println);
		;
	}
	
	// 11. iso2 값이 숫자 형태인 것만 출력해본다.
	public static void printIso2IsInteger(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		
	}
	
	// 12. iso2 값이 숫자형태가 아닌 도시의 국가명(countryName)을 오름차순 정렬해 출력해본다.
	public static void printIso2IsNotInteger(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		
	}
	
	// 13. 국가명(countryName) 별 도시의 목록을 그룹핑하여 출력해본다.
	public static void printCityListGrouping(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		
	}
	
	// 14. latitude와 longitude가 없는 도시들의 이름만 출력해본다.
	public static void printNotHaveLatitudeLongitude(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.filter(city -> city.getLatitude() == null)
				.filter(city -> city.getLongitude() == null)
				.map(city -> city.getName())
				.forEach(System.out::println);
		;
	}
	
	// 15. 국가명(countryName)이 Canada인 도시 중 3개는 건너띄고 2개만 출력해본다.
	public static void printCanada(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.filter(city -> city.getCountryName().equals("Canada"))
				.skip(3)
				.limit(2)
				.forEach(System.out::println);
		;
	}
	
	// 16. level과 parentId가 0보다 큰 도시만 출력해본다.
	public static void printLevelParentIdUpperZero(String path, String filename) {
		Stream<City> cityList = CityList.loadCityStream(path, filename);
		cityList.filter(city -> city.getLevel() > 0)
				.filter(city -> city.getParentId() > 0)
				.forEach(System.out::println);
		;
	}
	
	public static void main(String[] args) {
		String path = "C:\\Users\\User\\Downloads\\java-stream-countries-states-cities-database-master\\csv";
		String filename = "states.csv";
		
		Stream<City> cityList = CityList.loadCityStream(path, filename);
//		cityList.forEach(System.out::println);
		
//		System.out.println(1 + "=".repeat(50));
//		printCityName(path, filename); // O
		
//		System.out.println(2 + "=".repeat(50));
//		printSouthKoreaNative(path, filename); // O
		
//		System.out.println(3 + "=".repeat(50));
//		printCityPopulation(path, filename); // O
		
//		System.out.println(4 + "=".repeat(50));
//		printCityPopulationUpperZero(path, filename); // O
		
//		System.out.println(5 + "=".repeat(50));
//		printTimeZone(path, filename); // O
		
//		System.out.println(6 + "=".repeat(50));
//		printCityNameUpperTen(path, filename); // O
		
//		System.out.println(7 + "=".repeat(50));
//		printSouthKoreaPopulation(path, filename); // O
		
//		System.out.println(8 + "=".repeat(50));
		printPopulationUptoTen(path, filename); // X
		
		System.out.println(9 + "=".repeat(50));
		printCountryNameType(path, filename); // X
		
//		System.out.println(10 + "=".repeat(50));
//		printCityId(path, filename); // O
		
		System.out.println(11 + "=".repeat(50));
		printIso2IsInteger(path, filename); // X
		
		System.out.println(12 + "=".repeat(50));
		printIso2IsNotInteger(path, filename); // X
		
		System.out.println(13 + "=".repeat(50));
		printCityListGrouping(path, filename); // X
		
//		System.out.println(14 + "=".repeat(50));
//		printNotHaveLatitudeLongitude(path, filename); // O
		
//		System.out.println(15 + "=".repeat(50));
//		printCanada(path, filename); // O
		
//		System.out.println(16 + "=".repeat(50));
//		printLevelParentIdUpperZero(path, filename); // O
		
	}
	
}
