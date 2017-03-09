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
COMMENTAIRE=\/\*.*\*\/
NOM=[a-zA-Z0-9]+
NOMBRE=[0-9]+
EGAL=[\ \t]*=[\ \t]*
PV=[\ \t]*\;[\ \t]*
VIRG=[\ \t]*\,[\ \t]*
RETOUR=([\ \t]*\r[\ \t]*|[\ \t]*\n[\ \t]*|[\ \t]*\r[\ \t]*\n[\ \t]*)+
%%

/* regles */

{COMMENTAIRE}		{ return new Symbol(sym.COMMENTAIRE); }
{CRO_OUVR}			{ return new Symbol(sym.CRO_OUVR); }
{CRO_FERM}			{ return new Symbol(sym.CRO_FERM); }
"int"				{ return new Symbol(sym.INT); }
"nothing"			{ return new Symbol(sym.NOTHING); }
"func"				{ return new Symbol(sym.FUNC); }
{EGAL}				{ return new Symbol(sym.EGAL); }
{PV}				{ return new Symbol(sym.PV); }
{VIRG}				{ return new Symbol(sym.VIRG); }
{ESPACE}			{ return new Symbol(sym.ESPACE); }
{NOMBRE}			{ return new Symbol(sym.NOMBRE); }
{NOM}				{ return new Symbol(sym.NOM); }	
{RETOUR}			{ return new Symbol(sym.RETOUR); }
.					{ return null;}