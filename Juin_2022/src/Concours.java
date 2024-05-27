import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Concours {

    private Candidat[] tableCandidats;
    private HashMap<String,Candidat> mapCandidats; //nom --> candidat
    private HashMap<String,Integer> mapVotants; //numero de telephone --> nombre de votes
    private int nombreMaxVotes;

    /**
     * debute un concours
     * @param tableNomsCandidats la table avec les noms des candidats
     * @param nombreMaxVotes le nombre maximal de votes qu'un spectateur peut faire
     * @throws IllegalArgumentException
     *           s'il n'y a pas au moins un vote possible par spectateur
     *           si la table des noms des candidats est null ou est vide
     *           s'il y a des homonymes
     */
    public Concours(String[]tableNomsCandidats,int nombreMaxVotes){
        //TODO
        mapCandidats = new HashMap<>();
        tableCandidats = new Candidat[tableNomsCandidats.length];
        mapVotants = new HashMap<>();
        this.nombreMaxVotes=nombreMaxVotes;
        int n=0;
        for (String candidat : tableNomsCandidats) {
            Candidat temp = new Candidat(candidat, n+1);
            mapCandidats.put(candidat, temp);
            tableCandidats[n]=temp;
            n++;
        }
    }

    public int getNombreMaxVotes() {
        return nombreMaxVotes;
    }

    /**
     * ajoute 1 vote au candidat dont le nom est passe en parametre
     * a condition que le candidat existe
     * et a condition que le nombre max de votes n'est pas atteint pour le numero de telephone passe en parametre
     * @param numeroTelephone le numero de telephone qui fait le vote
     * @param nomCandidat le nom du candidat qui fait l'objet du vote
     * @return true si le vote a ete fait, false sinon
     * @throws IllegalArgumentException
     *              si le numero de telephone est null
     *              si le nom du candidat est null
     */
    public boolean voterViaNom(String numeroTelephone, String nomCandidat) {
        //TODO
        if (nomCandidat==null || numeroTelephone==null)
            throw new IllegalArgumentException();
        if (mapVotants.getOrDefault(numeroTelephone, 0) >= nombreMaxVotes)
            return false;
        if (!mapCandidats.containsKey(nomCandidat)) 
            return false;
        Candidat candidat = mapCandidats.get(nomCandidat);
        candidat.ajouter1Vote();
        mapVotants.put(numeroTelephone, mapVotants.getOrDefault(numeroTelephone, 0)+1);
        return true;
    }

    /**
     * ajoute 1 vote au candidat dont le numero est passe en parametre
     * a condition que le candidat existe
     * et a condition que le nombre max de votes n'est pas atteint pour le numero de telephone passe en parametre
     * @param numeroTelephone le numero de telephone qui fait le vote
     * @param numeroCandidat le numero du candidat qui fait l'objet du vote
     * @return true si le vote a ete fait, false sinon
     * @throws IllegalArgumentException si le numero de telephone est null
     */
    public boolean voterViaNumero(String numeroTelephone, int numeroCandidat) {
        //TODO
        if (numeroTelephone==null)          
            throw new IllegalArgumentException();
        int currentVotes = mapVotants.getOrDefault(numeroTelephone, 0);
        if (currentVotes >= nombreMaxVotes)
            return false;
        Candidat temp=null;
        for (Candidat candidat : tableCandidats) {
            if (candidat.getNumero()==numeroCandidat) {
                temp=candidat;
                break;
            }
        }
        if (temp==null)
            return false;
        temp.ajouter1Vote();
        mapVotants.put(numeroTelephone, currentVotes+1);
        return true;
    }

    /**
     * construit une table dans laquelle les candidats apparaissent tries selon l'ordre decroissant des nombres de vote
     * @return la table dans laquelle les candidats apparaissent tries selon l'ordre decroissant des nombres de vote
     */
    public Candidat[] classement(){
        // Utilisez les methodes copyOf() et sort() de la classe Arrays !
        // cfr enonce
        //TODO
        Candidat[] temp = Arrays.copyOf(tableCandidats, tableCandidats.length);
        Arrays.sort(temp, new ComparateurCandidats());
        return temp;
    }

    @Override
    // A NE PAS MODIFIER
    public String toString() {
        return "maxVotes=" + nombreMaxVotes +
                "\ntableCandidats=" + Arrays.toString(tableCandidats) +
                "\nmapCandidats=" + mapCandidats +
                "\nmapVotants=" + mapVotants;
    }

}

