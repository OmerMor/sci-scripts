;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Feature)
(use Game)
(use Actor)
(use System)

(public
	rmMap 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = 5
	local6 = 5
	local7
	local8
	local9
	local10
	local11
	[local12 15] = [{Parkway} {1st    } {2nd    } {3rd    } {4th    } {5th    } {6th    } {7th    } {8th    } {9th    } {10th   } {Walls  } {11th   } {12th   } {13th   }]
	[local27 9] = [{Aspen} {Palm } {Oak  } {Fig  } {Peach} {Rose } {Lilly} {Poppy} {River}]
	[local36 20]
	local56
	local57
	local58
)

(procedure (localproc_0 param1)
	(if local57
		(Display 202 0 dsRESTOREPIXELS local57)
		(= local57 0)
	)
	(if param1
		(= local57
			(Display
				param1
				dsWIDTH
				300
				dsCOORD
				10
				15
				dsALIGN
				alCENTER
				dsFONT
				1
				dsCOLOR
				(proc0_15 global118 global119 global118)
				dsSAVEPIXELS
			)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1) ; UNUSED
	(= temp1 1)
	(cond
		((& (OnControl CONTROL gMouseX gMouseY) $0020)
			(= temp0 64)
		)
		((& (OnControl CONTROL gMouseX gMouseY) $0004)
			(= temp0 128)
		)
		((& (OnControl CONTROL gMouseX gMouseY) $0008)
			(= temp0 256)
		)
		((& (OnControl CONTROL gMouseX gMouseY) $0010)
			(= temp0 512)
		)
		(else
			(= temp1 0)
		)
	)
	(if temp1
		(|= local2 temp0)
	)
)

(procedure (localproc_2 &tmp temp0 temp1)
	(= temp1 0)
	(if (IsFlag 80)
		(switch local0
			(1
				(if (== local1 4)
					(= temp1 5)
				)
				(if (== local1 5)
					(= temp1 2)
				)
			)
			(2
				(if (== local1 4)
					(= temp1 4)
				)
				(if (== local1 3)
					(= temp1 3)
				)
			)
			(3
				(if (== local1 2)
					(= temp1 3)
				)
				(if (== local1 5)
					(= temp1 1)
				)
			)
			(4
				(if (== local1 1)
					(= temp1 5)
				)
				(if (== local1 2)
					(= temp1 4)
				)
			)
			(5
				(if (== local1 3)
					(= temp1 1)
				)
				(if (== local1 1)
					(= temp1 2)
				)
			)
		)
		(if temp1
			(= temp0 (<< $0001 (mod temp1 16)))
			(if (== (|= local2 temp0) 62)
				(if (not (IsFlag 163))
					(SetScore 163 10)
					(Print 202 1) ; "Your pattern has formed a perfect pentagram. Can this show the location of the next murder?"
				)
				(SetFlag 64)
			)
		)
	)
)

(procedure (localproc_3 &tmp temp0)
	(for ((= temp0 (= local56 0))) (IsObject [local36 temp0]) ((++ temp0))
		([local36 temp0] dispose:)
		(= [local36 temp0] 0)
	)
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2)
	(= local11 (= local10 0))
	(= local9 (= local8 32767))
	(for ((= temp0 0)) (< temp0 argc) ((+= temp0 2))
		(= temp1 [param1 temp0])
		(if (< (= temp2 [param1 (+ temp0 1)]) local8)
			(= local8 temp2)
		)
		(if (> temp2 local10)
			(= local10 temp2)
		)
		(if (< temp1 local9)
			(= local9 temp1)
		)
		(if (> temp1 local11)
			(= local11 temp1)
		)
	)
	(-= local9 2)
	(-= local8 2)
	(+= local11 2)
	(+= local10 2)
)

(instance rmMap of Rm
	(properties
		picture 202
		style 5
	)

	(method (init)
		(super init:)
		(theRoom init:)
		(quitBut
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 307 289 289 289 289)
			init:
		)
		(pointBut
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 54 50 50 50 50)
			init:
		)
		(drawBut
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 167 156 156 156 156)
			init:
		)
		(cleanBut
			view: (proc0_20 1971 197 197 197 197)
			x: (proc0_20 238 237 237 237 237)
			init:
		)
		(gTheIconBar disable:)
		(= local58 (proc0_15 global138 global138 26))
	)

	(method (doit)
		(cond
			(script 0)
			((== local7 1)
				(pointBut loop: 1 forceUpd:)
				(Animate (gCast elements:) 0)
				(pointBut loop: 0 forceUpd:)
				(Animate (gCast elements:) 0)
				(star init:)
				(gGame setCursor: 69)
				(gCurRoom setScript: addPoint)
				(localproc_0 {PLOT MODE})
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(script handleEvent: event)
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (dispose)
		(MapEdit_GKarte_editieren dispose:)
		(super dispose:)
	)
)

(instance addPoint of Script
	(properties)

	(method (doit &tmp [temp0 75] temp75)
		(super doit:)
		(cond
			((& (OnControl CONTROL gMouseX gMouseY) $007e)
				(if (& (star signal:) $0080)
					(star show:)
				)
				(star posn: gMouseX gMouseY)
				(gGame setCursor: 69)
				(if (> gMouseX 138)
					(= temp75 {E})
				else
					(= temp75 {W})
				)
				(if 1
					(= global186 (Memory memALLOC_CRIT (StrLen temp75)))
					(= global192 (Memory memALLOC_CRIT (StrLen temp75)))
					(StrSplitInTwo global186 global192 temp75)
					(Display
						(Format ; "%3d %s"
							@temp0
							202
							2
							(* 100 (Abs (/ (- 138 gMouseX) 22)))
							global186
							(* 100 (Abs (/ (- 138 gMouseX) 22)))
							global192
						)
						dsFONT
						1
						dsCOORD
						20
						160
						dsCOLOR
						global137
						dsBACKGROUND
						local58
						dsALIGN
						alLEFT
					)
					(Memory memFREE global186)
					(Memory memFREE global192)
				)
				(Display
					(Format @temp0 202 3 [local27 (- (/ (- gMouseY 4) 16) 1)]) ; "%s"
					dsFONT
					1
					dsCOORD
					80
					160
					dsCOLOR
					global137
					dsBACKGROUND
					local58
					dsALIGN
					alLEFT
				)
				(if (> gMouseY 91)
					(= temp75 {S})
				else
					(= temp75 {N})
				)
				(Display
					(Format ; "%3d %s"
						@temp0
						202
						4
						(* 100 (Abs (/ (- 91 gMouseY) 16)))
						temp75
					)
					dsFONT
					1
					dsCOORD
					20
					177
					dsCOLOR
					global137
					dsBACKGROUND
					local58
					dsALIGN
					alLEFT
				)
				(Display
					(Format @temp0 202 3 [local12 (/ (+ gMouseX 5) 22)]) ; "%s"
					dsFONT
					1
					dsCOORD
					80
					177
					dsCOLOR
					global137
					dsBACKGROUND
					local58
					dsALIGN
					alLEFT
				)
			)
			((not (& (star signal:) $0080))
				(star hide:)
				(gGame setCursor: 999)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance quitBut of Prop
	(properties
		x 289
		y 10
		view 197
		cel 4
		priority 15
		signal 22545
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2] temp2)
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) (proc0_20 101 113 113 113 113))
						(== (event message:) (proc0_20 69 81 81 81 81 81))
						(and (== (event message:) KEY_RETURN) (MousedOn self event))
					)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(self loop: 0 forceUpd:)
					(Animate (gCast elements:) 0)
					(gCurRoom newRoom: gPrevRoomNum)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(self loop: 0 forceUpd:)
					(Animate (gCast elements:) 0)
					(gCurRoom newRoom: gPrevRoomNum)
					(event claimed: 1)
				)
			)
			($0044 ; direction | evKEYBOARD
				(= temp2 (event modifiers:))
				(switch (event message:)
					(JOY_UP
						(if (> local6 5)
							(-= local6 5)
						)
					)
					(JOY_DOWN
						(if (< local6 175)
							(+= local6 5)
						)
					)
					(JOY_RIGHT
						(if (< local5 314)
							(+= local5 5)
						)
					)
					(JOY_LEFT
						(if (> local5 6)
							(-= local5 5)
						)
					)
				)
				(SetCursor 999 1 local5 local6)
				(event claimed: 1)
			)
		)
	)
)

(instance pointBut of Prop
	(properties
		x 50
		y 10
		view 197
		cel 12
		priority 15
		signal 22545
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) (proc0_20 102 112 112 112 112))
						(== (event message:) (proc0_20 70 80 80 80 80))
						(and (== (event message:) KEY_RETURN) (MousedOn self event))
					)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(self loop: 0 forceUpd:)
					(Animate (gCast elements:) 0)
					(star init:)
					(gGame setCursor: 69)
					(gCurRoom setScript: addPoint)
					(localproc_0 {PLOT MODE})
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(self loop: 0 forceUpd:)
					(Animate (gCast elements:) 0)
					(star init:)
					(gGame setCursor: 69)
					(gCurRoom setScript: addPoint)
					(localproc_0 {PLOT MODE})
					(event claimed: 1)
				)
			)
		)
	)
)

(instance star of Prop
	(properties
		x 50
		y 10
		view 197
		loop 2
		priority 15
		signal 22545
	)
)

(instance drawBut of Prop
	(properties
		x 156
		y 10
		view 197
		cel 13
		priority 15
		signal 22545
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) (proc0_20 112 99 99 99 99))
						(== (event message:) (proc0_20 80 67 67 67 67))
						(and (== (event message:) KEY_RETURN) (MousedOn self event))
					)
					(localproc_0 {DRAW MODE})
					(= local7 2)
					(addPoint dispose:)
					(star dispose:)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(self loop: 0 forceUpd:)
					(Animate (gCast elements:) 0)
					(MapEdit_GKarte_editieren init:)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(localproc_0 {DRAW MODE})
					(= local7 2)
					(addPoint dispose:)
					(star dispose:)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(self loop: 0 forceUpd:)
					(Animate (gCast elements:) 0)
					(MapEdit_GKarte_editieren init:)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cleanBut of Prop
	(properties
		x 237
		y 10
		view 197
		cel 14
		priority 15
		signal 22545
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event &tmp [temp0 2])
		(switch (event type:)
			(evKEYBOARD
				(if
					(or
						(== (event message:) (proc0_20 108 101 101 101 101))
						(== (event message:) (proc0_20 76 69 69 69 69))
						(and (== (event message:) KEY_RETURN) (MousedOn self event))
					)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(self loop: 0 forceUpd:)
					(Animate (gCast elements:) 0)
					(addPoint dispose:)
					(localproc_3)
					(star dispose:)
					(= local7 0)
					(localproc_0 0)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if (MousedOn self event)
					(self loop: 1 forceUpd:)
					(Animate (gCast elements:) 0)
					(self loop: 0 forceUpd:)
					(Animate (gCast elements:) 0)
					(addPoint dispose:)
					(localproc_3)
					(star dispose:)
					(= local7 0)
					(localproc_0 0)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(InRect nsLeft nsTop nsRight nsBottom event)
						(== (event message:) KEY_RETURN)
						(gCurRoom script:)
						(& (OnControl CONTROL gMouseX gMouseY) $007e)
					)
					(if (== local56 19)
						(Print 202 5) ; "Come now. There aren't that many homicides you're working on Sonny."
					else
						((= [local36 local56] (Clone star)) init:)
						(++ local56)
					)
					(event claimed: 1)
				)
			)
			(evMOUSEBUTTON
				(if
					(and
						(gCurRoom script:)
						(MousedOn self event)
						(& (OnControl CONTROL gMouseX gMouseY) $007e)
					)
					(if (== local56 19)
						(Print 202 5) ; "Come now. There aren't that many homicides you're working on Sonny."
					else
						((= [local36 local56] (Clone star)) init:)
						(++ local56)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(class MapEdit_GKarte_editieren of Obj
	(properties
		name {MapEdit}
		x 0
		y 0
		state 1
		firstPtx -1
		firstPty -1
		lastPtx 0
		lastPty 0
	)

	(method (handleEvent event &tmp temp0 temp1)
		(MapKeyToDir event)
		(= x (event x:))
		(= y (event y:))
		(switch (event type:)
			(evNULL
				(if
					(and
						(!= (self firstPtx:) -1)
						(& (OnControl CONTROL (event x:) (event y:)) $007e)
					)
					(self movePt: x y)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(cond
					((MousedOn cleanBut event)
						(self clean:)
					)
					((MousedOn quitBut event)
						(= state 0)
						(self exit:)
						(return)
					)
					((MousedOn pointBut event)
						(= local7 1)
						(self exit:)
						(return)
					)
					((& temp0 emSHIFT)
						(self exit:)
						(return)
					)
					((& (OnControl CONTROL (event x:) (event y:)) $007e)
						(self addPt:)
					)
				)
			)
			(evKEYBOARD
				(cond
					(
						(or
							(==
								(= temp1 (event message:))
								(proc0_20 108 101 101 101 101)
							)
							(== temp1 (proc0_20 76 69 69 69 69))
						)
						(self clean:)
					)
					(
						(or
							(== temp1 (proc0_20 101 113 113 113 113))
							(== temp1 (proc0_20 69 81 81 81 81))
						)
						(= state 0)
						(self exit:)
						(return)
					)
					(
						(or
							(== temp1 (proc0_20 102 112 112 112 112))
							(== temp1 (proc0_20 70 80 80 80 80))
						)
						(= local7 1)
						(self exit:)
						(return)
					)
					(
						(and
							(== temp1 KEY_RETURN)
							(& (OnControl CONTROL (event x:) (event y:)) $007e)
						)
						(self addPt:)
					)
				)
			)
			($0044 ; direction | evKEYBOARD
				(switch (event message:)
					(JOY_UP
						(if (> local6 5)
							(-= local6 5)
						)
					)
					(JOY_DOWN
						(if (< local6 175)
							(+= local6 5)
						)
					)
					(JOY_RIGHT
						(if (< local5 314)
							(+= local5 5)
						)
					)
					(JOY_LEFT
						(if (> local5 6)
							(-= local5 5)
						)
					)
				)
				(SetCursor 999 1 local5 local6)
				(event claimed: 1)
			)
		)
		(return 0)
	)

	(method (show)
		(Graph grUPDATE_BOX 0 0 190 320 1)
	)

	(method (addPt)
		(cond
			((& (OnControl CONTROL x y) $0004)
				(if (== firstPtx -1)
					(= local0 1)
				else
					(= local1 1)
				)
			)
			((& (OnControl CONTROL x y) $0008)
				(if (== firstPtx -1)
					(= local0 2)
				else
					(= local1 2)
				)
			)
			((& (OnControl CONTROL x y) $0010)
				(if (== firstPtx -1)
					(= local0 3)
				else
					(= local1 3)
				)
			)
			((& (OnControl CONTROL x y) $0020)
				(if (== firstPtx -1)
					(= local0 4)
				else
					(= local1 4)
				)
			)
			((& (OnControl CONTROL x y) $0040)
				(if (== firstPtx -1)
					(= local0 5)
				else
					(= local1 5)
				)
			)
			(else
				(= local0 (= local1 0))
			)
		)
		(if (== (self firstPtx:) -1)
			(self firstPtx: x firstPty: y)
			(SetCursor gNormalCursor 1 x y)
		else
			(UnLoad 133 local3)
			(if (== (self firstPtx:) -1)
				(Graph
					grDRAW_LINE
					(self firstPty:)
					(self firstPtx:)
					(self lastPty:)
					(self lastPtx:)
					(proc0_15 12 12 global137)
					-1
					-1
				)
			)
			(Graph grUPDATE_BOX local8 local9 local10 local11 1 -1 -1)
			(Graph grREDRAW_BOX 0 0 200 320)
			(= local3 0)
			(self firstPtx: -1 firstPty: -1)
			(localproc_2)
		)
	)

	(method (movePt param1 param2)
		(if local3
			(Graph grRESTORE_BOX local3)
			(= local3 0)
			(Graph grUPDATE_BOX local8 local9 local10 local11 local4 -1 -1)
		)
		(localproc_4 (self firstPtx:) (self firstPty:) param1 param2)
		(= local3 (Graph grSAVE_BOX local8 local9 local10 local11 local4 -1 -1))
		(Graph
			grDRAW_LINE
			(self firstPty:)
			(self firstPtx:)
			param2
			param1
			(proc0_15 12 12 global137)
			-1
			-1
		)
		(Graph grUPDATE_BOX local8 local9 local10 local11 local4 -1 -1)
		(Graph grREDRAW_BOX 0 0 200 320)
	)

	(method (clean)
		(& local2 $000f)
		(DrawPic (gCurRoom curPic:) 100 1 global40)
		(gAddToPics doit:)
		(Animate (gCast elements:) 0)
	)

	(method (init)
		(= local4 1)
		(gDirectionHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self doit:)
	)

	(method (doit &tmp temp0)
		(repeat
			(= temp0 (Event new:))
			(GlobalToLocal temp0)
			(breakif (self handleEvent: temp0))
			(temp0 dispose:)
		)
		(temp0 dispose:)
		(self dispose:)
	)

	(method (exit)
		(return 1)
	)

	(method (dispose)
		(if local3
			(Graph grRESTORE_BOX local3)
			(= local3 0)
			(Graph grUPDATE_BOX local8 local9 local10 local11 local4 -1 -1)
		)
		(if (not (self state:))
			(gCurRoom newRoom: gPrevRoomNum)
		)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)
)

(instance myPics of List ; UNUSED
	(properties)
)

