/*  Scala uses packages to create
    namespaces which allow you to modularize programs.

    One convention is to name the package the same as the
    directory containing the Scala file.
    However, Scala is agnostic to file layout.
 */
package rps

object Main {
  def main(args: Array[String]): Unit = {
    println("""
#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
%&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
%&&&&&&&&&&&&&&&&&&&&&&&&&&&&********%&&&&&&&&&&&&&&&&&&&&&
%&&&&&&&&&&&&&&&&&&&&&&&&&&********%&&&&&&&&&&&&&&&&&&&&&&&
%&&&&&&&&&&&&&&&&&&&&&&&&/*********/&&&&&&&&&&&&&&&&&&&&&&&
%&&&&&&&&&&&&&&&&&&&&&&***************&&&&&&&&&&&&&&&&&&&&&
#&&&&&&&&&&&&&&&&&&&&********#&%********&&&&&&&&&&&&&&&&&&&
#&&&&&&&&&&&&&&&&&&/*******#&&&&&#*******/&&&&&&&&&&&&&&&&&
#&&&&&&&&&&&&&&&&(*******(&&&&%&&&&#*******/&&&&&&&&&&&&&&&
#&&&&&&&&&&&&&&/*******#&&&&#***(&&&&%********&&&&&&&&&&&&&
#&&&&&&&&&&&&(*******#&&&&#*******(&&&&%*******/&&&&&&&&&&&
#&&&&/#&&&&/*******#&&&&/************&&&&%********&&&&&&&&&
#%%%%///#/*******#%%%%#***************(&%%%%********&%%%%%%
#%%%%///*******#%%%%#*******************(%%%%%*******/%%%%%
#%%%%********#%%%%/************************%%%%%********%%%
#%%%%%/*******#%%%%#*********%%%*********(%%%%#********/%%%
#%%%%%%%/*******#%%%%(*****%%%%%%%*****/%%%%#********///%%%
#%%%%%%%%%(*******#%%%%#/%%%%%%%%%%%/(%%%%#*******/%%%//%%%
#%%%%%%%%%%%(*******#%%%%%%%%%%%%%%%%%%%#********%%%%%%%%%%
#%%%%%%%%%%%%%/******%%%%%%%%%%%%%%%%%%%*******%%%%%%%%%%%%
#%%%%%%%%%%%%%%%(*/%%%%%%%%%%%%%%%%%%%%%%%/*/%%%%%%%%%%%%%%
#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
#%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

""")
    println("Let's play!\n")
    Game.play()
  }
  /* Alternatively we could do:

    ```scala
        object Main extends App {
        println("Wanna play?)
        }
    ```
 */

}