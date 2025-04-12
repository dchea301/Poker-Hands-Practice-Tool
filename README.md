# Poker-Hands-Practice-Tool

This Java project provides a poker hand evaluation system along with a basic game board framework. It is designed to identify different poker hands from a set of cards and provides an extendable Game class for board-based games.

# Game Framework (model package)

The Game class provides a reusable framework for building board-based games:

Initializes a board (2D array of Cell objects)

Methods to set rows, columns, and the whole board to a specific color or state

Abstract methods to define game-specific behavior:

- isGameOver()

- getScore()

- nextAnimationStep(Integer piece)

- processCell(Action action)

# TODO

Use this framework to create a Poker Hand Evaluator that will show hand strength pre-flop, post-flop, after the turn, and on the river. 
Use Game Theory Optimal (GTO) to recommend bet sizing and recommend the best play.
