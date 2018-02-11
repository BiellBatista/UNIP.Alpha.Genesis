/* %W% %E% Gabriel Batista
 *
 * Copyright (c) 2000-2012 Raz�o Social Ltda. Todos os direitos reservados.
 *
 * Esse software � informa��o confidencial e propriet�ria da Raz�o
 * Social Ltda. ("Informa��o Confidencial"). Voc� n�o deve divulgar
 * tal Informa��o Confidencial e deve us�-la apenas em concord�ncia
 * com os termos de acordo de licen�a que voc� entrou com a Laranja Games Ltda.
 *
 * 
 * LARANJA GAMES LTDA N�O FAZ REPRESENTA��O OU D� GARANTIAS SOBRE A
 * ADEQUA��O DO SOFTWARE, SEJA EXPRESSA OU IMPLICADA, INCLUINDO MAS
 * N�O LIMITANDO AS GARANTIAS DE COMERCIALIZA��O, ADEQUA��O PARA UM
 * DETERMINADO FIM PARTICULAR OU N�O-VIOLA��O. LARANJA GAMES LTDA N�O
 * SER� RESPONS�VEL POR QUALQUER DANO SOFRIDO PELO LICENCIADO EM
 * DECORR�NCIA DO USO, MODIFICA��O OU DISTRIBUI��O DESSE SOFTWARE OU
 * SEUS DERIVADOS.
 */

package br.com.unip.cc.base;

/**
 * Esta classe � a base para os demais objetos (inimigos, tiros,..)
 * fundamentais no jogo. Ela serve para movimentar o objeto,
 * modar o angulo do mesmo e verificar se ele est� vivo.
 * 
 * @version 0.01 29/Ago/2016
 * @author Gabriel Batista
 */

public class BaseGameEntity extends Object {
	private boolean alive = false;
	private double x = 0, y = 0;
	private double velX = 0, velY = 0;
	private double moveAngle = 0, faceAngle = 0;

	BaseGameEntity() {
		setAlive(false);
		setX(0.0);
		setY(0.0);
		setVelX(0.0);
		setVelY(0.0);
		setMoveAngle(0.0);
		setFaceAngle(0.0);
	}

	public boolean isAlive() {
		return alive;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getVelX() {
		return velX;
	}

	public double getVelY() {
		return velY;
	}

	public double getMoveAngle() {
		return moveAngle;
	}

	public double getFaceAngle() {
		return faceAngle;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setVelX(double x) {
		this.velX = x;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public void setFaceAngle(double angle) {
		this.faceAngle = angle;
	}

	public void setMoveAngle(double angle) {
		this.moveAngle = angle;
	}

	/**M�todos de incremento*/
	public void incX(double i) {
		this.x += i;
	}

	public void incY(double i) {
		this.y += i;
	}

	public void incVelX(double i) {
		this.velX += i;
	}

	public void incVelY(double i) {
		this.velY += i;
	}

	public void incFaceAngle(double i) {
		this.faceAngle += i;
	}
	public void incMoveAngle(double i) {
		this.moveAngle += i;
	}
}