;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 227)
(include sci.sh)
(use Main)
(use Interface)
(use n804)
(use n819)
(use Talker)
(use Feature)
(use MoveFwd)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	enterScript 0
	exitScript 1
)

(class ApartmentRoom of Rm
	(properties)

	(method (init &tmp temp0)
		(super init:)
		(gAddToPics add: rock_1 rock_2 rock_3 rock_4 eachElementDo: #init)
		(aptExit init:)
		(NormalEgo)
		(gEgo init: view: 802 posn: 323 203)
		(if (not (gCurRoom script:))
			(gCurRoom setScript: (ScriptID 227 0)) ; enterScript
			(if
				(= temp0
					(switch gCurRoomNum
						(221 201)
						(222 205)
						(223 203)
						(224 202)
						(225 204)
						(226
							(if (IsFlag 53) 206 else 207)
						)
					)
				)
				(gLongSong number: temp0 loop: -1 play:)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1
							(gCurRoom north:)
						)
						(2
							(gCurRoom east:)
						)
						(3
							(gCurRoom south:)
						)
						(4
							(gCurRoom west:)
						)
					)
				)
				(gCurRoom setScript: (ScriptID 227 1) 0 temp0) ; exitScript
			)
		)
	)

	(method (newRoom)
		(HandsOff)
		(super newRoom: &rest)
	)

	(method (dispose)
		(gLongSong fade:)
		(super dispose:)
		(DisposeScript 227)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if lookStr
					(if (< 0 lookStr 300)
						(Narrator init: lookStr)
					else
						(Print lookStr)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(10 ; Recycle
				(Narrator init: (Random 121 124) 0 4)
			)
			(5 ; Talk
				(Narrator init: (Random 130 134) 0 4)
			)
			(3 ; Do
				(Narrator init: (Random 125 129) 0 4)
			)
			(4 ; Inventory
				(Narrator init: (Random 135 139) 0 4)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (dispose)
		(gEgo ignoreActors: 0)
		(super dispose: &rest)
		(gCurRoom notify:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreActors: 1)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 271 172 self)
			)
			(2
				(= cycles 5)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 0)
				(or (> (gEgo nsLeft:) 320) (> (gEgo nsTop:) 190))
			)
			(= cycles 1)
		)
	)

	(method (dispose)
		(gEgo ignoreActors: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					setCycle: Walk
					setHeading: 135
					setMotion: MoveFwd 200
				)
			)
			(1
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance rock_1 of PicView
	(properties
		x 186
		y 46
		onMeCheck 0
		view 220
		loop 1
		cel 2
		priority 0
		signal 16400
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
)

(instance rock_2 of PicView
	(properties
		x 182
		y 95
		onMeCheck 0
		view 220
		loop 1
		priority 0
		signal 16400
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
)

(instance rock_3 of PicView
	(properties
		x 170
		y 25
		onMeCheck 0
		view 220
		loop 1
		cel 1
		priority 0
		signal 16400
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
)

(instance rock_4 of PicView
	(properties
		x 195
		y 27
		onMeCheck 0
		view 220
		loop 1
		cel 1
		priority 0
		signal 16400
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)
)

(instance aptExit of Feature
	(properties
		x 271
		y 183
		nsTop 177
		nsLeft 224
		nsBottom 189
		nsRight 319
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 10)
			)
			(3 ; Do
				(Narrator init: 12)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

