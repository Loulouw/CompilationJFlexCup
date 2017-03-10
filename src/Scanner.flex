/*
 * analyseur lexical du langage exemple-expr:
 * (voir support de cours CUP)
 *
 * auteur : azim.roussanaly@univ-lorraine.fr
 * (c) 2013
 */

package fr.ul.miage.exemple.generated;
import java_cup.runtime.Symbol;

%%

/* options */
%line
%public
%cup
%debug

/* macros */
CRO_OUVR=[\ \t]*\{[\ \t]*
CRO_FERM=[\ \t]*\}[\ \t]*
ESPACE=[\ \t]+
COMMENTAIRE=\/\*([^*]|[\r\n]|(\*+([^*\/]|[\r\n])))*\*\/
NOM=[a-zA-Z]+[a-zA-Z0-9]*
NOMBRE=[0-9]+
EGAL=[\ \t]*=[\ \t]*
PV=[\ \t]*\;[\ \t]*
VIRG=[\ \t]*\,[\ \t]*
RETOUR=([\ \t]*\r[\ \t]*|[\ \t]*\n[\ \t]*|[\ \t]*\r[\ \t]*\n[\ \t]*)+
PLUS=[\ \t]*\+[\ \t]*
MOINS=[\ \t]*\-[\ \t]*
FOIS=[\ \t]*\*[\ \t]*
DIV=[\ \t]*\/[\ \t]*
PO=[\ \t]*\([\ \t]*
PF=[\ \t]*\)[\ \t]*
INF=[\ \t]*\<[\ \t]*
SUP=[\ \t]*\>[\ \t]*
DIFF=[\ \t]*\!\=[\ \t]*
%%

/* regles */
{COMMENTAIRE}		{ return new Symbol(sym.COMMENTAIRE); }
{CRO_OUVR}			{ return new Symbol(sym.CRO_OUVR); }
{CRO_FERM}			{ return new Symbol(sym.CRO_FERM); }
"int"				{ return new Symbol(sym.INT); }
"nothing"			{ return new Symbol(sym.NOTHING); }
"func"				{ return new Symbol(sym.FUNC); }
"return"			{ return new Symbol(sym.RETURN); }
"si"				{ return new Symbol(sym.SI); }
"sinon"				{ return new Symbol(sym.SINON); }
"tq"				{ return new Symbol(sym.TQ); }
"lire"				{ return new Symbol(sym.LIRE); }
"ecrire"			{ return new Symbol(sym.ECRIRE); }
{INF}				{ return new Symbol(sym.INF); }
{SUP}				{ return new Symbol(sym.SUP); }
{DIFF}				{ return new Symbol(sym.DIFF); }
{PLUS}				{ return new Symbol(sym.PLUS); }
{MOINS}				{ return new Symbol(sym.MOINS); }
{FOIS}				{ return new Symbol(sym.FOIS); }
{DIV}				{ return new Symbol(sym.DIV); }
{PO}				{ return new Symbol(sym.PO); }
{PF}				{ return new Symbol(sym.PF); }
{EGAL}				{ return new Symbol(sym.EGAL); }
{PV}				{ return new Symbol(sym.PV); }
{VIRG}				{ return new Symbol(sym.VIRG); }
{ESPACE}			{ return new Symbol(sym.ESPACE); }
{NOMBRE}			{ return new Symbol(sym.NOMBRE); }
{NOM}				{ return new Symbol(sym.NOM); }	
{RETOUR}			{ return new Symbol(sym.RETOUR); }
.					{ return null;}