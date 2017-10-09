package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Regle_Frame extends JFrame{
	
	JButton retour = new JButton("Retour");
	
	public Regle_Frame(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);  
		 
        JPanel panel = new JPanel();  
        panel.add(retour);   
        
        //JPanel panel2 = new JPanel();
        //试着放几个不同的label和textArea来放不同部分的规则
        
        //从apocalypse之后的规则没加进来
        JTextArea textArea = new JTextArea("Début de partie "+
"    Chaque joueur pioche une Divinité au hasard et la place devant lui. 7 cartes d’Action sont distribuées à tous les joueurs. \n"+
"\n"+
"Déroulement d’un tour de jeu\n"+
"\n"+
"    Cartes d’Action Chaque tour de jeu commence par le lancement du dé de Cosmogonie \n" +
"pour connaître la manière dont va être influencé ce tour. Le résultat du jet de dé va donner aux joueurs des points d’Action :\n" +
"  -face Jour : donne 2 points aux Divinités d’Origine Jour\n "+
"               donne 1 point aux Divinités d’Origine Aube \n"+
"  -face Nuit : donne 2 points aux Divinités d’Origine Nuit\n"+
"               donne 1 point aux Divinités d’OrigineCrépuscule \n"+
"  -face Néant : donne 1 point aux Divinités Aube et Crépuscule \n"+
"\n"+
"Les points d’Action ont une Origine (Jour, Nuit ou Néant), qui va décider des cartes d’Action que la Divinité pourra jouer. \n"+
"Chaque joueur peut ensuite, à son tour de jeu : \n"+
"  1.se défausser de tout ou partie de ses cartes\n" +
"  2.Compléter sa main à 7 cartes\n "+
"  3.Jouer les deux phases suivantes tant que ses cartes le lui permettent\n"+
"    - utiliser les cartes d’Action qu’il a en main\n "+
"    - sacrifier une carte Croyants ou Guide Spirituel\n" +
"\n"+
"Le joueur qui a lancé le dé de Cosmogonie est celui qui aura commencé à jouer sur ce tour. Au tour suivant, c’est le deuxième\n " +
"joueur qui lance le dé et qui commence à jouer ; le premier joueur sera donc celui qui jouera en dernier ce tour-ci, et ainsi de suite.\n"+ 
"\n"+
"Cartes d’action\n"+
"\n"+
"On distingue 4 types de cartes d’Action différents : les cartes de Croyants, les Guides Spirituels, les DeusEx et les Apocalypses.\n "+
"Pour chaque carte d’Action posée, il en coûte 1 point d’Action de même Origine (Jour, Nuit ou Néant) ; \n" +
"seule exception, les cartes d’Action d’Origine Néant qui peuvent être posées en échange de 2 points d’Action d’Origine Jour ou Nuit.\n"+
"Il existe des cartes d’Action sans Origine, qui se jouent sans coûter de point d’Action, et peuvent même être jouées pendant\n" +
" la phase de jeu d’un autre joueur.\n "+
"\n"+
"LesCroyants\n"+
"\n"+
"Les cartes de Croyantssont posées par les joueurs au centre de la table. Elles sont communes à tous.\n "+
"Ce sont les Croyants qui apportent leur puissance aux Divinité. Les cartes représentent un nombre de Croyants différent\n" +
" (donc toutes les cartes de Croyants n’auront pas la même importance lors du calcul final des points de Prière). \n"+
"Les Croyants possèdent des capacités spéciales qui permettent de faire certaines actions en contre partie d’un sacrifice\n " +
"(la carte est alors défaussée). Une carte de Croyants ne peut pas être sacrifiée lorsqu’elle est encore au centre de la table. \n"+
"\n"+
"Les Guides Spirituels\n"+
"\n"+
"Lorsque les Croyants sont au milieu de la table, ils ne rapportent aucun point de Prière aux Divinités. Pour que celles-ci\n" +
" récupèrent les prières des Croyants, il faut qu'elles utilisent des Guides Spirituels. \n"+
"Chaque Guide Spirituel peut ramener avec lui un groupe de plusieurs cartes de Croyants (le nombre est inscrit sur la carte)\n" +
" auprès d'une Divinité. Elle récupère alorsles prières desCroyants en question.\n"+
"Un Guide Spirituel peut très bien guider des Croyants ayant une Cosmogonie (Jour/Nuit/Néant) différente de la sienne.\n" +
" Mais il ne peut guider que desCroyants ayant au moins un Dogme (Nature, Humain, Symboles, Chaos, Mystique) en commun avec lui.\n" +
" Un joueur ne peut pas utiliser un Guide Spirituel pour récupérer un carte de Croyants qu'il vient de créer ;\n" +
" c'est à partir de la phase de jeu du joueur suivant que la carte de Croyants sera utilisable. \n"+
"Les Guides Spirituels possèdent des capacités spéciales en échange de sacrifices (il est alors défaussé, et les Croyants\n" +
" qui y étaient attachés reviennent au centre de la table). Un Guide Spirituel n'ayant plus de Croyants rattachés à lui\n" +
"(à la suite de sacrifices par exemple) est défaussé. Sa capacité spéciale de sacrifice n'est pas jouée. \n"+
"\n"+
"Les cartes Deus Ex \n"+
"\n"+
"Ces cartes ont des capacités spéciales, agissant sur les Croyants ou les Guides Spirituels en jeu, voire directement sur les\n " +
"Divinités. Leur effet est immédiat. Les Deus Ex sans Origine peuvent être utilisées à n’importe quel moment, sans coûter de \n" +
"point d’Action.\n" +
"\n"+
"Apocalypse\n"+
"\n"+
"Lorsqu'un joueur pose une carte Apocalypse, un bouleversement divin a lieu, qui interrompt la partie. Tous les joueurs \n" +
"additionnent a1orsle nombre de Croyants qu'ils possèdent(une carte de Croyants pouvant représenter plusieurs Croyants). \n" +
"Cela correspond aux points de Prière, la puissance reçue par la Divinité. Deux cas de figure se présentent a1ors:\n"+
"    - 4 joueurs ou plus: lejoueur ayant la plus faible puissance de Prière est eliminé de la partie.\n " +
"      Si plusieurs joueurs sont les derniers à égalité, la carte Apocalypse est défaussée sans effet.\n"+
"    - 2 ou 3 joueurs: lejoueur ayant la plus forte puissance de Prière gagne la partie. Si plusieurs joueurs sont premiers\n " +
"      à égalité, la carte Apocalypse est défaussée sans effet.\n"+
"\n"+
"Il est interdit dejouer une carte Apocalypse durant le premier tour de la partie, ainsi que durant le tourqui suit une Apocalypse.\n"+
"Après une Apocalypse, et si la partie n'est pas terminée, le joueur qui a posé la carte commence un nouveau tour de jeu.\n " +
"Les cartes présentes sur la table ne sont pas défaussées, à l'exception des Guides Spirituels du joueur qui s'est fait éliminer\n" +
"(les Croyant qui y étaient attaché reviennent au centre de la table).\n"+
"\n"+
"De la même manière que pour les cartes Deus Ex, i1 existe des Apocalypses avec Origine(Jour, Nuit ou Néant) qui coûtent des points \n" +
"d'Action pour être posées, ainsi que des Apocalypses sans Origine, qui peuvent être posées à tout moment sans rien coûter.\n"+
"\n"+
"Mythologie\n"+
"\n"+
"Dans le monde de Pandocréon, les hommes prient le Haut Dieu, chacun à leur manière; certains vénèrent la lumière du solei1,\n " +
"d'autres les voies du surnature1, d'autres encore sont athées et ne croient qu'en 1'espèce humaine. Toutes ces prières et ces \n" +
"croyances remontent au Haut Dieu et lui donnent sa puissance.\n"+
"Néanmoins, dans 1'ombre de ce Tout-Puissant, de nombreuses Divinités\n"+
"mineures essayent de récupérer à leur avantage les prières des hommes pour prendre le pas les unes sur les autres, et surtout\n " +
"pour prendre la place du Haut Dieu. Pour cela, e11es envoient des émissaires, des Guides Spirituels qui vont habilement canaliser\n " +
"les prières de leurs adeptes pour en récolter la puissance.\n"+
"Les Divinités sont issues des forces origine11es du Jour et de la Nuit. Certaines ont vu leur apparition se placer sous 1'influence \n" +
"du Néant qui, combiné à 1'action  du Jour ou de la Nuit, 1es a fait émerger de 1'Aube ou du Crépuscule.\n"+
"\n"+
"Présentation au jeu\n"+
"\n"+
"Vous incarnez des Divinités,,qui sont caractérisées par leur Origine (Jour,,Nuit, Aube ou Crépuscule) qui exprime leur filiation,\n " +
"et leurs Dogmes (3 parmi: Nature, Humain, Symboles, Mystique, Chaos) qui définissent leurs  croyances. Chaque Divinité possèdent\n" +
"une capacité spéciale, un pouvoir utilisable une unique fois pendant la partie.\n"+
"Le but du jeu est d’éliminer les autres Divinités et de prendre la place du Haut Dieu en récupérant les prières d'un maximum de Croyants.\n"+
"Pour cela, les joueurs vont créer des Croyants, qui seront mis en commun au milieu de la table. Par la suite, les joueurs pourront\n" +
" créer des Guides Spirituels, dont le role est d'amener à une Divinité un nombre variable de cartes de Croyants.\n " +
"A cela s'ajoute des cartes Deus Ex qui modifient les rapports de force en cours de partie.\n"+
"Lorsqu'une carte Apocalypse est posée, un joueur est éliminé (4 joueurs ou plus) ou un joueur gagne la partie (2 ou 3 joueurs)\n " +
"en fonction des points de Prière apportés par les Croyants de chaque Divinité.\n"
        ,50, 15);
        
        
        textArea.setLineWrap(true); 
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);  
        getContentPane().add(panel, BorderLayout.SOUTH);  
        getContentPane().add(scrollPane, BorderLayout.CENTER);  
 
        pack(); 
		
		
		setResizable(false);  
        setSize(800, 600);  
        setTitle("Pandocreon-Règle");  
        
        this.retour.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
            	setVisible(false);
                Bienvenu_Frame frame_main=new Bienvenu_Frame();
                frame_main.show();
            }  
        });
	}

}
