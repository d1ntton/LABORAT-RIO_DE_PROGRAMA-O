/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Principal {

    public static void main(String[] args) {

        Herois goku = new Goku();
        goku.setNome("Goku");
        goku.setVida(100);
        goku.setEnergia(100);

        Herois sonic = new Sonic();
        sonic.setNome("Sonic");
        sonic.setVida(100);
        sonic.setEnergia(80);

        Herois mario = new Mario();
        mario.setNome("Mario");
        mario.setVida(100);
        mario.setEnergia(90);

        System.out.println("===== GOKU =====");
        goku.apresentar();
        goku.atacar();

        System.out.println("\n===== SONIC =====");
        sonic.apresentar();
        sonic.atacar();

        System.out.println("\n===== MARIO =====");
        mario.apresentar();
        mario.atacar();
    }
}