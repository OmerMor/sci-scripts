;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2500)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v50 0
)

(instance rm2v50 of ShiversRoom
	(properties
		picture 2290
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2291)
		)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2120
	)

	(method (init)
		(self
			createPoly:
				66
				143
				100
				123
				138
				112
				182
				105
				179
				105
				179
				0
				263
				0
				263
				142
		)
		(super init: &rest)
	)
)

