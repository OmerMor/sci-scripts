;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64996)
(include sci.sh)
(use Main)
(use System)

(instance uEvt of Event
	(properties)

	(method (new)
		(= type (= message (= modifiers (= y (= x (= claimed (= plane 0)))))))
		(GetEvent gEventMask self)
		(return self)
	)
)

(class User of Obj
	(properties
		alterEgo 0
		input 0
		controls 0
		prevDir 0
		x -1
		y -1
		mapKeyToDir 1
		curEvent 0
	)

	(method (init)
		(= curEvent uEvt)
	)

	(method (canInput n)
		(if argc
			(= input n)
		)
		(return input)
	)

	(method (doit)
		(curEvent new:)
		(self handleEvent: curEvent)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(= temp0 (event type:))
		(= temp2 (event modifiers:))
		(= temp5 0)
		(if (not (gTalkers isEmpty:))
			(repeat
				(= gGameTime (+ gTickOffset (GetTime)))
				(gTalkers eachElementDo: #doit firstTrue: #handleEvent event)
				(gSounds eachElementDo: #check)
				((ScriptID 88 0) doit:) ; PointGauge
				(= temp5 1)
				(FrameOut)
				(breakif (gTalkers allTrue: 454 2))
				(curEvent new:)
			)
		)
		(if (not (gPrints isEmpty:))
			(repeat
				(= gGameTime (+ gTickOffset (GetTime)))
				(gPrints eachElementDo: #doit firstTrue: #handleEvent event)
				(gSounds eachElementDo: #check)
				(= temp5 1)
				((ScriptID 88 0) doit:) ; PointGauge
				(FrameOut)
				(breakif (gPrints allTrue: 454 2))
				(curEvent new:)
			)
		)
		(if (not temp5)
			((ScriptID 88 0) doit:) ; PointGauge
		)
		(if temp0
			(= gLastEvent event)
			(if (and mapKeyToDir (!= temp0 evKEYUP))
				(MapKeyToDir event)
			)
			(if (== temp0 $0020) ; joyUp
				(= temp0 evKEYBOARD)
				(= temp1 (if (& temp2 emSHIFT) 27 else 13))
				(= temp2 $0000)
				(event type: temp0 message: temp1 modifiers: $0000)
			)
			(if (and gSpeechHandler (gSpeechHandler handleEvent: event))
				(return 1)
			)
			(event localize: (gCast plane:))
			(= temp0 (event type:))
			(= temp1 (event message:))
			(cond
				((& temp0 $0100) ; speechEvent
					(cond
						(
							(and
								(== temp1 JOY_UP)
								(or
									(= temp4
										(gCast firstTrue: #perform findNoun)
									)
									(= temp4
										(gFeatures firstTrue: #perform findNoun)
									)
								)
							)
							(temp4 doVerb: ((gTheIconBar curIcon:) message:))
						)
						((= temp4 (gTheIconBar findIcon: temp1))
							(gTheIconBar select: temp4)
							(gGame setCursor: (temp4 cursor:))
						)
					)
				)
				((& temp0 $0010) ; direction
					(cond
						((and gDirectionHandler (gDirectionHandler handleEvent: event))
							(return 1)
						)
						(
							(and
								(or
									(and
										gTheIconBar
										(==
											(gTheIconBar curIcon:)
											(gTheIconBar walkIconItem:)
										)
									)
									(not gTheIconBar)
								)
								alterEgo
								controls
								(gCast contains: alterEgo)
								(alterEgo handleEvent: event)
							)
							(return 1)
						)
						(
							(and
								gPMouse
								(or (not (& temp0 evKEYBOARD)) (!= temp1 JOY_NULL))
								(gPMouse handleEvent: event)
							)
							(return 1)
						)
					)
				)
				((and (& temp0 evKEYBOARD) gKeyDownHandler (gKeyDownHandler handleEvent: event))
					(return 1)
				)
				((and (& temp0 evMOUSE) gMouseDownHandler (gMouseDownHandler handleEvent: event))
					(return 1)
				)
			)
		)
		(if (and gExtMouseHandler (gExtMouseHandler handleEvent: event))
			(return 1)
		)
		(if gTheIconBar
			(gTheIconBar handleEvent: event)
		)
		(if (event claimed:)
			(return 1)
		)
		(= temp0 (event type:))
		(= temp1 (event message:))
		(if (and input (& temp0 evVERB))
			(cond
				((and (& temp0 evMOVE) gWalkHandler (gWalkHandler handleEvent: event))
					(return 1)
				)
				(
					(and
						(& temp0 evMOVE)
						(gCast contains: alterEgo)
						controls
						(alterEgo handleEvent: event)
					)
					(return 1)
				)
				(gUseSortedFeatures
					(OnMeAndLowY init:)
					(gCast eachElementDo: #perform OnMeAndLowY event)
					(gFeatures eachElementDo: #perform OnMeAndLowY event)
					(if
						(and
							(OnMeAndLowY theObj:)
							((OnMeAndLowY theObj:) handleEvent: event)
						)
						(return 1)
					)
				)
				((gCast handleEvent: event)
					(return 1)
				)
				((gFeatures handleEvent: event)
					(return 1)
				)
			)
			(if (and (not (event claimed:)) (gRegions handleEvent: event))
				(return 1)
			)
		)
		(if (and temp0 (gGame handleEvent: event))
			(return 1)
		)
		(if (gEgo mover:)
			(= global178 (Random 30 120))
		)
		(return 0)
	)

	(method (canControl value)
		(if argc
			(= controls value)
			(= prevDir 0)
		)
		(return controls)
	)
)

(class OnMeAndLowY of Code
	(properties
		theObj 0
		lastY -1
	)

	(method (init)
		(= theObj 0)
		(= lastY -1)
	)

	(method (doit thisObj event)
		(if (and (thisObj onMe: event) (> (thisObj y:) lastY))
			(= theObj thisObj)
			(= lastY (theObj y:))
		)
	)
)

(instance findNoun of Code
	(properties)

	(method (doit theObj theNoun)
		(return (== (theObj noun:) theNoun))
	)
)

