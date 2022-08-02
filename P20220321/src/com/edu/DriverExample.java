package com.edu;

public class DriverExample {
	public static void main(String[] args) {

		Vehicle v1 = new Vehicle();
		v1 = new Taxi();
		v1 = new Bus();

		Driver driver = new Driver();
		driver.drive(v1); // 매개변수의 다형성.

		Vehicle vehicle = new Vehicle();
		Taxi taxi = new Taxi();
		Bus bus = new Bus();

		System.out.println("Vehicle의 최고속력: " + vehicle.getMaxSpeed());
		System.out.println("Taxi의 최고속력: " + taxi.getMaxSpeed());
		System.out.println("Bus의 최고속력: " + bus.getMaxSpeed());

		Vehicle[] vehicles = new Vehicle[3];
		vehicles[0] = vehicle;
		vehicles[1] = taxi;
		vehicles[2] = bus;

		// 속도가 제일 빠른 타는것의 정렬해서 vehicles[0]=taxi, vehicles[1]=bus, vehicles[2]=vehicle
		// if(intAry[i] > intAry[i+1])
		// if(vehicles[i].getMaxSpeed() 크다 작다 비교...위치를 변경.
		int loopCnt = vehicles.length - 1; // 마지막값이 제일 처음위치로 이동하려면 배열크기-1;
		for (int cnt = 0; cnt < loopCnt; cnt++) {
			Vehicle temp = vehicles[0]; // 첫번째 값으로 temp값을 지정.
			for (int i = 0; i < loopCnt; i++) {
				if (vehicles[i].getMaxSpeed() < vehicles[i + 1].getMaxSpeed()) {
					temp = vehicles[i];
					vehicles[i] = vehicles[i + 1];
					vehicles[i + 1] = temp;
				}
			}
		}
		System.out.println("제일빠른거: " + vehicles[0].toString());// 택시의 최고속도는 120입니다.
		System.out.println("제일느린거: " + vehicles[2].toString());// 탈것의 최고속도는 100입니다.
	}
}
