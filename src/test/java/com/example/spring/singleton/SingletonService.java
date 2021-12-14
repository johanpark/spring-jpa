package com.example.spring.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    //java static영역에 대해 공부하기

    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private으로 선언해서
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
