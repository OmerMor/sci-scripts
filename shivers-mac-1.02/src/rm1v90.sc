;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1090)
(include sci.sh)
(use Main)

(public
	rm1v90 0
)

(instance rm1v90 of ShiversRoom
	(properties
		picture 1090
	)

	(method (init &tmp temp0 temp1)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(= temp1 (Random 1 20))
		(= temp0 (Random 5 10))
		(cond
			((< 0 temp1 4)
				(gSounds playChain: -1 temp0 10119 0)
				(gSounds adjChainVol: 42)
			)
			((< 3 temp1 7)
				(gSounds playChain: -1 temp0 10122 0)
				(gSounds adjChainVol: 42)
			)
			((< 6 temp1 10)
				(gSounds playChain: -1 temp0 10123 0)
				(gSounds adjChainVol: 42)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1091
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1091
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1093
	)

	(method (init)
		(self
			createPoly:
				113
				140
				114
				105
				80
				107
				83
				91
				96
				73
				111
				61
				129
				61
				144
				68
				153
				82
				158
				101
				143
				102
				180
				142
		)
		(super init: &rest)
	)
)

