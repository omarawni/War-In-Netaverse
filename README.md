# War-In-Netaverse

**Introduction**
I am developing an early prototype of a strategy game titled “War in Netaverse” (WIN). At this stage, the game provides a very simplified version for a single player. In the future, it will support multiplayer functionality over the web, introduce more complex battles and forces, and incorporate random elements. However, these features are planned for later development stages. This prototype focuses on allowing the player to take on different roles, although the current implementation includes code for just one role.


**Game Description**

In "War in Netaverse" (WIN), I’ve designed a strategy game where the player assumes the role of the “Admiral of the United Forces Fleet (UFF)” within the Netaverse Federation of Worlds. The Federation is currently engaged in battles against various enemies from the Terraworld Empire. As the Admiral, your primary objective is to assemble an Active Star Fleet (ASF) from the UFF to confront and, ideally, win these battles. The game offers a range of UFF forces that can be activated to form your fleet. Initially, all UFF forces are in reserve ("in dock") and not part of your ASF. You’ll be able to choose from a variety of battle scenarios, but the game will automatically select the first available force from your ASF to engage in the battle.

In addition to your role as Admiral, you can take on other roles within the game. As the War Minister, you'll manage the UFF forces, adding new ones or decommissioning old ones. As the Head of Intelligence, you'll update information about your enemies. 

Your war chest starts with 1000 bit coins, provided by the War Ministry. Activating forces from the UFF dock costs money, and you'll need to strategically manage your funds to assemble your ASF. Winning battles will increase your war chest, while losing battles will deplete it. If one of your forces is defeated in a battle, it is destroyed and can no longer be used.

Each battle in the game is uniquely identified by a number, a battle type, the enemy name, enemy strength (ranging from 1 to 10), and the potential gains and losses. Players can select a battle by its number, and the game will match the first appropriate force from your ASF to engage in combat. Battle outcomes are determined by comparing the battle strengths of your ASF force and the enemy, leading to one of three possible results:

- **Battle won by the ASF force:** Your force’s battle strength is equal to or greater than the enemy's, and you gain additional bit coins.
- **Battle lost due to no suitable force available:** No appropriate force is found in your ASF, leading to losses.
- **Battle lost by ASF force:** Your force’s battle strength is less than the enemy's, resulting in losses and the destruction of your force.

In this version, battles can be undertaken multiple times. The UFF forces include Wings, Starships, and WarBirds, each with specific activation fees and battle strengths. The War Ministry has placed restrictions on the use of certain forces in particular battle types to save resources and lives.

Throughout the game, forces can exist in one of three states:
- **Docked:** In reserve and not yet activated as part of your ASF.
- **Active:** Activated as part of your ASF and available for battles.
- **Destroyed:** Defeated and no longer usable.

If your war chest falls below 0, you won't be able to activate more forces, but you can continue to engage in battles with your remaining ASF forces in the hope of gaining more bit coins. Forces can be recalled to the dock at any time, returning half of their original activation cost to your war chest. However, if your war chest is empty or in debt, and you have no forces to recall, the game ends with a suitable message. 

The game allows players to save and load their progress, and features a "Highest Scores" table to track achievements. Although this early version may seem basic, it is designed to establish a solid foundation for future enhancements, including the introduction of more complex features and random elements. The current design ensures a clear structure, making it easier to implement these future updates.

The functional requirements for this version include user interface elements that allow the player to input the Admiral's name, assemble their ASF, and engage in battles. The system will manage and display the state of the war chest, ASF forces, and UFF docked forces, and provide options to activate or recall forces, as well as save or load the game. These foundational features will be expanded upon in future iterations to create a more dynamic and engaging experience.
