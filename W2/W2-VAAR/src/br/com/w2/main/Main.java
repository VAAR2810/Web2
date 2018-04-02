/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.w2.main;

import javax.persistence.Persistence;

/**
 *
 * @author VAAR
 */
public class Main {
    public static void main(String[] args) {
        Persistence.createEntityManagerFactory("W2VAAR");
        System.out.println("AE!");
    }
}