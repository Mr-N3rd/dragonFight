import kotlin.math.floor

fun main() {
    println("what is your name brave warrior")
    val player:Player = Player()
    val trogdor:Dragon = Dragon("Trogdor", 300, 12 )
    dragonFight(player, trogdor)
}

class Player(var name: String?, var health: Int?, val attackPower: Int) {
    init {
        println("what is your name Traveller")
        this.name = readln();
        println("lets see how powerful you are")
        this.health = floor(Math.random() * 100).toInt()
    }
    fun attack(opponent: Dragon) {
        println("$name attacks ${opponent.name} for $attackPower damage.")
        opponent.health = opponent.health!! - attackPower
    }
//    fun defend(opponent: Dragon){
//        currentDamage=(opponent.attackPower!! /2)
//    }
}

class Dragon(var name: String, var health: Int?, var attackPower: Int?) {
    init {
        name = "Trogdor"
        println("lets see how powerful your enemy is")
        health = floor(Math.random() * 100).toInt()
        attackPower=floor(Math.random() * 5).toInt()
    }
    fun attack(opponent: Player) {;
        println("$name attacks ${opponent.name} for $attackPower damage.")
        println("do you defend against $name attack? y or n")
        var defense:String = readln()
        var thisAttack:Int?
        if (defense=="y"){
             thisAttack=(attackPower?.div(2))
        } else if ( defense == "n" ){
             thisAttack=(attackPower)
        } else {
            println("WRONG MAXIMUM POWER")
            thisAttack=(attackPower)
        }
        if (thisAttack != null) {
            opponent.health = opponent.health?.minus(thisAttack)
        }
    }
}

fun dragonFight(player: Player, dragon: Dragon) {
    while (player.health!! > 0 && dragon.health!! > 0) {
        player.attack(dragon)
        if (dragon.health!! <= 0) {
            println("${dragon.name} is defeated! ${player.name} wins!")
            break
        }
        dragon.attack(player)
        if (player.health!! <= 0) {
            println("${player.name} is defeated! ${dragon.name} wins!")
            break
        }
    }
}
