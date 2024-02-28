
public class JeuGuerrier {
	
	public static void main(String[] args) {
		EquipeGuerriers equipe = new EquipeGuerriers(3, 10);
		int pointsDeVieDuMal = 30;
		
		// A COMPLETER
		
		
//		System.out.println("L'equipe compte guerriers en vie");
//		System.out.println("Suite au combat entre la creature du mal et le guerrier n°");
//		System.out.println("Le guerrier vient de perdre points de vie");
//		System.out.println("La creature du mal vient de perdre points de vie");
//		System.out.println("Il lui reste points de vie");
//		System.out.println("Le guerrier est mort");
//		System.out.println("La creature du mal est morte");
//		System.out.println("Tous les guerriers sont morts");
	}
	
	public static int lancerDe (){
		double nombreReel;
		nombreReel = Math.random();
		return (int) (nombreReel * 6) + 1;
	}
	
}
