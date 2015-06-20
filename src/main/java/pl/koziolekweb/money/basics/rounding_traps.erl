%%%-------------------------------------------------------------------
%%% @author koziolek
%%% @copyright (C) 2015, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 18. mar 2015 20:02
%%%-------------------------------------------------------------------
-module(rounding_traps).
-author("koziolek").
%% API
-export([trap/0]).

trap() ->
  Numbers = [0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9],
  lists:foreach(fun(Nb) ->
    io:format("~w ~w ~n", [Nb, 1 + Nb - Nb == Nb - Nb + 1])
  end,
    Numbers).
