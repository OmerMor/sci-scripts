;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use n804)
(use eRS)
(use Smopper)
(use n819)
(use EcoFeature)
(use Talker)
(use Osc)
(use MoveFwd)
(use ForwardCounter)
(use LoadMany)
(use DPath)
(use Motion)
(use System)

(public
	rm660 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1)
	(EcoNarrator init: 2 0 0 param1 self)
)

(procedure (localproc_1)
	(ClearFlag 83)
	(gLongSong2 stop:)
	(outsideHarpoon dispose:)
	(insideHarpoon dispose:)
	(if (gCast contains: harpoonHead)
		(harpoonHead dispose:)
	)
	(eyeFeature init:)
	(finFeature init:)
	(water init:)
	(whaleMouth init:)
	(upperWhale init:)
	(mouthFeature init:)
	(gEgo
		setCycle: 0
		view: 663
		setLoop: -1
		setLoop: gStopGroop
		cel: 6
		setCycle: Smopper 664 667 0 13
		posn: 161 137
	)
	(fin init:)
	(harpoon init:)
	(eye init:)
	(if (not (IsFlag 85))
		(eye hide: setScript: eyeScript)
	else
		(eye cel: 2 stopUpd:)
	)
)

(procedure (localproc_2)
	(gEgo
		signal: 4096
		view: 663
		z: 0
		setLoop: -1
		setLoop: gStopGroop
		setPri: -1
		setMotion: 0
		illegalBits: 0
		ignoreActors: 0
		ignoreHorizon: 0
		setStep: 4 3
		setSpeed: 6
		setCycle: Smopper 664 667 0 13
	)
)

(instance rm660 of EcoRoom
	(properties
		picture 660
		style 10
		horizon 10
		south 640
	)

	(method (init)
		(= global250 3)
		(= global251 1)
		(LoadMany rsVIEW 813 641 643 660)
		(Load rsFONT 310)
		(LoadMany rsSCRIPT 951 956 939)
		(gEgo init:)
		(self setRegions: 51) ; bubblesRegion
		(if (IsFlag 132)
			(if
				(or
					(not (OneOf (gLongSong number:) 640 644))
					(== (gLongSong prevSignal:) -1)
				)
				(gLongSong number: 640 loop: 1 play:)
			)
			(if (or (not (IsFlag 83)) (IsFlag 140))
				(= gPrevRoomNum south)
				(eye init:)
				(if (not (IsFlag 85))
					(eye hide: setScript: eyeScript)
				else
					(eye cel: 2 stopUpd:)
				)
				(eyeFeature init:)
				(finFeature init:)
				(water init:)
				(whaleMouth init:)
				(upperWhale init:)
				(mouthFeature init:)
				(localproc_2)
				(gEgo loop: 7 posn: 210 150)
				(fin init:)
				(harpoon cel: (IsFlag 96) init:)
			else
				(NormalEgo)
				(= picture 661)
				(wound1 init:)
				(wound2 init:)
				(distanceInMouth init:)
				(teeth init:)
				(outsideOfMouth init:)
				(gLongSong2 number: 641 loop: -1 play:)
				(gEgo posn: 121 131 heading: 45 loop: 6 setPri: 7)
				(insideHarpoon init:)
				(outsideHarpoon init:)
				(self setScript: bogusScript)
			)
			(barnacles init:)
			(if (and (IsFlag 96) (not (IsFlag 88)))
				(gEgo setScript: cleanWoundTimer)
			)
			(cond
				((IsFlag 140) 0)
				((IsFlag 90)
					(gEgo posn: 273 189 setLoop: 0)
					(self setScript: crashIntoMouth)
				)
				((not (IsFlag 85))
					(self setScript: talkCetus)
				)
			)
		else
			(gLongSong2 number: 660 loop: -1 play:)
			(harpoon init:)
			(gEgo
				setCycle: 0
				view: 663
				setLoop: 3
				cel: 6
				setCycle: Walk
				posn: 172 207
			)
			(self setScript: enterScript)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(cond
					((IsFlag 83)
						(EcoNarrator init: 3 0 0 8) ; "The whale's mouth is like a large cavern covered with barnacles."
					)
					((and (IsFlag 85) (not (IsFlag 88)))
						(EcoNarrator init: 3 0 0 33) ; "Cetus is too weak to do anything further. His struggles are nearly at an end."
					)
					(else
						(EcoNarrator init: 3 0 0 2) ; "Adam is floating near the mighty King Cetus. Cetus has been trapped by a harpoon and forced to stay at the surface for air. His wound is infected and he's weakening rapidly."
					)
				)
			)
			(4 ; Do
				(if (IsFlag 83)
					(EcoNarrator init: 3 0 0 55) ; "Adam is trying to be gentle with Cetus and doesn't want to play around needlessly in the whale's mouth."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 56) ; "There's nothing that can be thrown away here."
			)
			(44 ; Inventory
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 58) ; "The healing potion won't do Cetus any good if Adam puts it there."
					)
					(37
						(EcoNarrator init: 3 0 0 42) ; "Cetus doesn't need to be cut any more than he already is."
					)
					(17
						(EcoNarrator init: 3 0 0 42) ; "Cetus doesn't need to be cut any more than he already is."
					)
					(else
						(if (IsFlag 83)
							(EcoNarrator init: 3 0 0 55) ; "Adam is trying to be gentle with Cetus and doesn't want to play around needlessly in the whale's mouth."
						else
							(EcoNarrator init: 3 0 0 57) ; "That won't help Cetus."
						)
					)
				)
			)
			(2 ; Talk
				(if (IsFlag 83)
					(EcoNarrator init: 3 0 0 27) ; "Adam's voice echoes back to him."
				else
					(EcoNarrator init: 3 0 0 32) ; "Cetus is too weak to talk further."
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(Palette palANIMATE 209 222 7)
		(cond
			(script
				(script doit:)
			)
			((& temp0 $0002)
				(gCurRoom newRoom: 640)
			)
			((== (gEgo edgeHit:) 3)
				(self setScript: leaveRoom)
			)
			((OneOf (gEgo edgeHit:) 4 2)
				(self setScript: stayAndHelp)
			)
		)
	)

	(method (notify)
		(HandsOn)
	)

	(method (newRoom newRoomNumber)
		(gEgo setScript: 0)
		(gLongSong2 stop:)
		(ClearFlag 83)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 90)
				(SetFlag 132)
				(= cycles 1)
			)
			(1
				(EcoNarrator init: 3 0 0 45 self) ; "...until suddenly..."
			)
			(2
				(gEgo setMotion: MoveTo 172 157 self)
			)
			(3
				((ScriptID 2 1) init: 1 0 0 6 1 self) ; Adam, "WHOA!"
			)
			(4
				(gEgo
					view: 660
					setLoop: 1
					cel: 0
					posn: 173 156
					setCycle: End self
				)
			)
			(5
				(gSoundEffects number: 165 loop: 1 play:)
				(ShakeScreen 8 ssLEFTRIGHT)
				(= cycles 2)
			)
			(6
				(gCurRoom newRoom: 640)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo (gEgo x:) 220 self)
			)
			(1
				(gCurRoom newRoom: 640)
			)
		)
	)
)

(instance bogusScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stayAndHelp of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(EcoNarrator init: 0 0 23 self)
			)
			(1
				(Face gEgo 160 (gEgo y:) self)
			)
			(2
				(gEgo setMotion: MoveFwd 20 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance crashIntoMouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: 0
					view: 660
					setLoop: 0
					setCycle: Walk
					setStep: 7 6
					setMotion: MoveTo 219 140 self
				)
			)
			(1
				(gSoundEffects number: 165 loop: 1 play:)
				(ShakeScreen 4 ssLEFTRIGHT)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gCurRoom newRoom: 640)
			)
		)
	)
)

(instance talkCetus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 10 343)
				(SetFlag 85)
				(= seconds 3)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 1 1 self) ; Adam, "Your Majesty, you're hurt! No wonder you've been missing! You're trapped here by that harpoon!"
			)
			(2
				(localproc_0 1)
			)
			(3
				((ScriptID 2 1) init: 1 0 0 2 1 self) ; Adam, "But what happened! How did you get harpooned?"
			)
			(4
				(localproc_0 2)
			)
			(5
				((ScriptID 2 1) init: 1 0 0 3 1 self) ; Adam, "Can't you get free?! You can't just die! Eluria needs you!"
			)
			(6
				(localproc_0 3)
			)
			(7
				(EcoNarrator init: 3 0 0 35 self) ; "Cetus sinks into unconsciousness and his great eye shuts. The harpoon wound has become infected and he is near starvation from being trapped in this one spot."
			)
			(8
				(EcoNarrator init: 3 0 0 36 self) ; "Cetus is getting weaker by the moment."
			)
			(9
				(eye show: cel: 0 setScript: 0 setCycle: End self)
			)
			(10
				(= seconds 3)
			)
			(11
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance secondTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				((ScriptID 2 1) init: 1 0 0 4 1 self) ; Adam, "Cetus! You're awake! Are you feeling okay? Are you gonna make it?"
			)
			(2
				(localproc_0 4)
			)
			(3
				((ScriptID 2 1) init: 1 0 0 5 1 self) ; Adam, ""Now that you're better, we have to save Delphineus! Flesh-Eater took him and he's in terrible danger!"
			)
			(4
				(eye posn: 119 73 view: 662 loop: 5 cel: 0 setCycle: End self)
			)
			(5
				(= cycles 15)
			)
			(6
				(localproc_0 5)
			)
			(7
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance eyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(eye show: cel: 1)
				(= cycles (eye cycleSpeed:))
			)
			(2
				(eye hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance throwBack of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 90)
				(ShakeScreen 5 ssFULL_SHAKE)
				(= cycles 2)
			)
			(1
				(gCurRoom newRoom: 640)
			)
		)
	)
)

(instance cutHarpoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 90 self)
			)
			(1
				(= cycles 10)
			)
			(2
				(insideHarpoon hide: cel: 1)
				(harpoonHead posn: 132 57 init:)
				(gEgo
					setCycle: 0
					view: 641
					loop: 2
					cel: 0
					x: 114
					y: 68
					cycleSpeed: 10
				)
				(= cycles 1)
			)
			(3
				(if (<= (++ local1) 8)
					(-- state)
					(gSoundEffects number: 661 loop: 1 play:)
					(gEgo cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(4
				(gEgo setCycle: Beg)
				(SetFlag 86)
				(outsideHarpoon _approachVerbs: 0)
				(client setScript: harpoonFalls)
			)
		)
	)
)

(instance harpoonFalls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(insideHarpoon show: stopUpd:)
				(SetFlag 87)
				(SetFlag 131)
				(gLongSong2 number: 662 loop: 1 play:)
				(harpoonHead setCycle: Fwd setMotion: MoveTo 141 130 self)
			)
			(1
				(harpoonHead
					setCycle: 0
					cel: 3
					setMotion: DPath 145 136 150 140 157 150 160 200 self
				)
			)
			(2
				(harpoonHead dispose:)
				(NormalEgo 0)
				(gEgo setPri: 7 posn: 105 70)
				(EcoNarrator store: 37 init: 3 0 0 20) ; "Adam uses the industrial saw to cut through the harpoon shaft."
				(SetScore 5 340)
				(= cycles 2)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance removeHarpoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 131)
				(if register
					(gEgo setMotion: MoveTo 83 99 self)
				else
					(self changeState: 2)
				)
			)
			(1
				(= register 0)
				(gCurRoom drawPic: 660 10)
				(localproc_1)
				(= cycles 2)
			)
			(2
				(SetScore 5 341)
				(gEgo setMotion: MoveTo 144 124 self)
			)
			(3
				(gEgo
					setCycle: 0
					view: 643
					loop: 0
					cel: 0
					x: 132
					y: 124
					cycleSpeed: 10
					illegalBits: 0
				)
				(= cycles 2)
			)
			(4
				(EcoNarrator init: 3 0 0 21 self) ; "Adam carefully works the shaft backwards through the wound."
			)
			(5
				(gSoundEffects number: 663 loop: 1 play:)
				(gEgo setCycle: End self)
				(SetFlag 96)
				(harpoon cel: 1 forceUpd:)
			)
			(6
				(localproc_2)
				(gEgo loop: 2 posn: 138 123 setScript: cleanWoundTimer)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cleanWoundTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(EcoNarrator init: 3 0 0 34 self) ; "Although Adam has removed the source of infection, the wound still needs attention."
				(= state -1)
			)
		)
	)
)

(instance medicateWound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScript: 0 setMotion: MoveTo 138 123 self)
			)
			(1
				(= cycles 12)
			)
			(2
				(gEgo
					setCycle: 0
					view: 643
					setLoop: 1
					cel: 0
					posn: 145 118
					cycleSpeed: 10
				)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(if (not local0)
					(EcoNarrator posn: -1 10 init: 3 0 0 22 self) ; "Adam uses Demeter's precious store of medicine on the wound."
				else
					(= ticks 5)
				)
			)
			(5
				(gEgo setLoop: 3 cel: 0 setCycle: ForwardCounter 7 self)
			)
			(6
				(if (< (++ local0) 3)
					(self changeState: 2)
				else
					(SetScore 5 342)
					(SetFlag 88)
					(localproc_2)
					(gEgo put: 3 loop: 1 posn: 140 119 setHeading: 0 self) ; healingPotion
				)
			)
			(7
				(= cycles 12)
			)
			(8
				(eye setCycle: CT 1 -1 self)
			)
			(9
				(eye setCycle: Osc 1 self)
			)
			(10
				(eye stopUpd:)
				(gCurRoom setScript: secondTalk)
			)
		)
	)
)

(instance barnacles of EcoFeature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 83)
					(EcoNarrator init: 3 0 0 23) ; "A whale's mouth is often open when he swims, so that he can eat plankton and smaller creatures that get caught in his wake. The barnacles even ride on his teeth."
				else
					(EcoNarrator init: 3 0 0 38) ; "The sperm whale is covered with barnacles - natural passengers that do not harm the whale."
				)
			)
			(4 ; Do
				(EcoNarrator init: 3 0 0 16) ; "The barnacles are natural hitchhikers on whales and do not need to be removed."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 16) ; "The barnacles are natural hitchhikers on whales and do not need to be removed."
			)
			(2 ; Talk
				(upperWhale doVerb: 2 &rest)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance eyeFeature of EcoFeature
	(properties
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (IsFlag 85) (not (IsFlag 88)))
					(EcoNarrator init: 3 0 0 33) ; "Cetus is too weak to do anything further. His struggles are nearly at an end."
				else
					(EcoNarrator init: 3 0 0 2) ; "Adam is floating near the mighty King Cetus. Cetus has been trapped by a harpoon and forced to stay at the surface for air. His wound is infected and he's weakening rapidly."
				)
			)
			(4 ; Do
				(if (and (IsFlag 85) (not (IsFlag 88)))
					(EcoNarrator init: 3 0 0 31) ; "Adam can't force Cetus back to consciousness."
				else
					(upperWhale doVerb: 4 &rest)
				)
			)
			(2 ; Talk
				(upperWhale doVerb: 2 &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance finFeature of EcoFeature
	(properties
		onMeCheck 4096
		lookStr 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(upperWhale doVerb: 4 &rest)
			)
			(2 ; Talk
				(upperWhale doVerb: 2 &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance water of EcoFeature
	(properties
		onMeCheck 2048
		lookStr 2
	)
)

(instance whaleMouth of EcoFeature
	(properties
		onMeCheck 1024
		lookStr 6
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(cond
					((not (IsFlag 86))
						(EcoNarrator init: 3 0 0 39) ; "The back of the whale's mouth is closed here. Adam will have to get further away from the whale if he wants to get in Cetus' mouth."
					)
					((IsFlag 96)
						(EcoNarrator init: 3 0 0 52) ; "Adam doesn't need to get back into Cetus' mouth now that the harpoon head has been removed."
					)
					(else
						(upperWhale doVerb: 4 temp0 &rest)
					)
				)
			)
			(2 ; Talk
				(upperWhale doVerb: 2 temp0 &rest)
			)
			(44 ; Inventory
				(if (not (IsFlag 96))
					(switch temp0
						(29
							(EcoNarrator init: 3 0 0 50) ; "There's a much simpler way to get into Cetus' mouth. Swim further away."
						)
						(else
							(EcoNarrator init: 3 0 0 51) ; "That won't help Adam get into Cetus' mouth."
						)
					)
				else
					(EcoNarrator init: 3 0 0 52) ; "Adam doesn't need to get back into Cetus' mouth now that the harpoon head has been removed."
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance upperWhale of EcoFeature
	(properties
		onMeCheck 768
		lookStr 1
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (and (IsFlag 85) (not (IsFlag 88)))
					(EcoNarrator init: 3 0 0 33) ; "Cetus is too weak to do anything further. His struggles are nearly at an end."
				else
					(EcoNarrator init: 3 0 0 2) ; "Adam is floating near the mighty King Cetus. Cetus has been trapped by a harpoon and forced to stay at the surface for air. His wound is infected and he's weakening rapidly."
				)
			)
			(4 ; Do
				(EcoNarrator init: 3 0 0 5) ; "Cetus' skin is slightly hot to the touch, as though he has a fever."
			)
			(2 ; Talk
				(if (not (IsFlag 85))
					(gCurRoom setScript: talkCetus)
				else
					(EcoNarrator init: 3 0 0 32) ; "Cetus is too weak to talk further."
				)
			)
			(44 ; Inventory
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 58) ; "The healing potion won't do Cetus any good if Adam puts it there."
					)
					(37
						(EcoNarrator init: 3 0 0 42) ; "Cetus doesn't need to be cut any more than he already is."
					)
					(17
						(EcoNarrator init: 3 0 0 42) ; "Cetus doesn't need to be cut any more than he already is."
					)
					(else
						(EcoNarrator init: 3 0 0 57) ; "That won't help Cetus."
					)
				)
			)
			(6 ; Recycle
				(EcoNarrator init: 3 0 0 56) ; "There's nothing that can be thrown away here."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance insideHarpoon of EcoView
	(properties
		x 116
		y 65
		approachX 105
		approachY 70
		view 641
		loop 4
		priority 7
		signal 16401
	)

	(method (init)
		(if (IsFlag 86)
			(+= cel 1)
		)
		(super init: &rest)
		(self approachVerbs: 9 4) ; ???, Do
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 86)
					(EcoNarrator init: 3 0 0 18) ; "The shaft of the harpoon, now headless, is still lodged in the wound."
				else
					(EcoNarrator init: 3 0 0 12) ; "The harpoon has pushed through the whale's flesh. Its barbed head juts out several inches into the whale's mouth."
				)
			)
			(4 ; Do
				(if (IsFlag 86)
					(EcoNarrator init: 3 0 0 24) ; "Adam can't pull the harpoon out from inside the mouth - the cable is still attached to the boat below."
				else
					(EcoNarrator init: 3 0 0 13) ; "The harpoon head is barbed and has locked into position. It would stick in the wound like a fishhook if Adam tried to push it out."
				)
			)
			(44 ; Inventory
				(switch temp0
					(37
						(if (not (IsFlag 86))
							(gCurRoom setScript: cutHarpoon)
						else
							(EcoNarrator init: 3 0 0 40) ; "Now that the barbed head has been removed, there is no need to cut the harpoon further. Just pull it out."
						)
					)
					(12
						(EcoNarrator init: 3 0 0 14) ; "The infection can't be halted until its source is removed."
					)
					(17
						(EcoNarrator init: 3 0 0 41) ; "The sharp shell just isn't strong enough to cut through the harpoon shaft."
					)
					(else
						(EcoNarrator init: 3 0 0 59) ; "That won't help Adam free Cetus from the harpoon."
					)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance outsideHarpoon of EcoView
	(properties
		x 66
		y 81
		approachX 105
		approachY 70
		view 641
		loop 4
		cel 2
		priority 6
		signal 16401
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
		(if (not (gEgo has: 28)) ; hackSaw
			(self approachVerbs: 4) ; Do
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 86)
					(EcoNarrator init: 3 0 0 18) ; "The shaft of the harpoon, now headless, is still lodged in the wound."
				else
					(EcoNarrator init: 3 0 0 12) ; "The harpoon has pushed through the whale's flesh. Its barbed head juts out several inches into the whale's mouth."
				)
			)
			(4 ; Do
				(if (IsFlag 86)
					(gCurRoom setScript: removeHarpoon 0 1)
				else
					(EcoNarrator init: 3 0 0 13) ; "The harpoon head is barbed and has locked into position. It would stick in the wound like a fishhook if Adam tried to push it out."
				)
			)
			(44 ; Inventory
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 14) ; "The infection can't be halted until its source is removed."
					)
					(else
						(super doVerb: theVerb temp0 &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance fin of EcoProp
	(properties
		x 18
		y 70
		onMeCheck 0
		view 660
		loop 3
		signal 16400
		cycleSpeed 25
		detailLevel 2
	)

	(method (init)
		(self setCycle: Osc)
		(super init: &rest)
	)
)

(instance eye of EcoProp
	(properties
		x 139
		y 63
		onMeCheck 0
		view 660
		loop 2
		signal 16400
		cycleSpeed 25
		detailLevel 2
	)
)

(instance harpoon of EcoView
	(properties
		x 146
		y 107
		view 643
		loop 2
		signal 16401
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(cond
					((not (IsFlag 86))
						(EcoNarrator init: 3 0 0 46) ; "A harpoon is lodged in Cetus' jaw. From this side, only the shaft of the harpoon is visible. The barbed head of the harpoon is inside Cetus' mouth."
					)
					((IsFlag 96)
						(EcoNarrator init: 3 0 0 15) ; "Though the harpoon has been removed, it has left a nasty wound. The wound is infected and is preventing Cetus from recovering."
					)
					(else
						(EcoNarrator init: 3 0 0 18) ; "The shaft of the harpoon, now headless, is still lodged in the wound."
					)
				)
			)
			(4 ; Do
				(cond
					((not (IsFlag 86))
						(EcoNarrator init: 3 0 0 47) ; "The barbed head of the harpoon in Cetus' mouth prevents Adam from pulling the harpoon out. It would cause terrible damage to Cetus if the head of the harpoon were not first removed."
					)
					((not (IsFlag 96))
						(gCurRoom setScript: removeHarpoon)
					)
					(else
						(EcoNarrator init: 3 0 0 44) ; "The wound is infected and needs medication."
					)
				)
			)
			(44 ; Inventory
				(switch temp0
					(12
						(if cel
							(gCurRoom setScript: medicateWound)
						else
							(EcoNarrator init: 3 0 0 14) ; "The infection can't be halted until its source is removed."
						)
					)
					(37
						(cond
							((not (IsFlag 86))
								(EcoNarrator init: 3 0 0 48) ; "Cutting the harpoon at this end would be useless since the barbed head would still be in Cetus' mouth."
							)
							(cel
								(EcoNarrator init: 3 0 0 42) ; "Cetus doesn't need to be cut any more than he already is."
							)
							(else
								(EcoNarrator init: 3 0 0 40) ; "Now that the barbed head has been removed, there is no need to cut the harpoon further. Just pull it out."
							)
						)
					)
					(17
						(cond
							((not (IsFlag 86))
								(EcoNarrator init: 3 0 0 48) ; "Cutting the harpoon at this end would be useless since the barbed head would still be in Cetus' mouth."
							)
							(cel
								(EcoNarrator init: 3 0 0 42) ; "Cetus doesn't need to be cut any more than he already is."
							)
							(else
								(EcoNarrator init: 3 0 0 41) ; "The sharp shell just isn't strong enough to cut through the harpoon shaft."
							)
						)
					)
					(else
						(if cel
							(EcoNarrator init: 3 0 0 43) ; "That won't help clear up the infection in the wound."
						else
							(EcoNarrator init: 3 0 0 59) ; "That won't help Adam free Cetus from the harpoon."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance wound1 of EcoFeature
	(properties
		x 73
		y 77
		nsTop 73
		nsLeft 68
		nsBottom 82
		nsRight 78
		sightAngle 90
		lookStr 14
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 86)
					(EcoNarrator init: 3 0 0 18) ; "The shaft of the harpoon, now headless, is still lodged in the wound."
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(44 ; Inventory
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 14) ; "The infection can't be halted until its source is removed."
					)
					(else
						(EcoNarrator init: 3 0 0 43) ; "That won't help clear up the infection in the wound."
					)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance wound2 of EcoFeature
	(properties
		x 107
		y 66
		nsTop 61
		nsLeft 102
		nsBottom 71
		nsRight 112
		sightAngle 90
		lookStr 14
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 86)
					(EcoNarrator init: 3 0 0 18) ; "The shaft of the harpoon, now headless, is still lodged in the wound."
				else
					(super doVerb: theVerb temp0 &rest)
				)
			)
			(44 ; Inventory
				(switch temp0
					(12
						(EcoNarrator init: 3 0 0 14) ; "The infection can't be halted until its source is removed."
					)
					(else
						(EcoNarrator init: 3 0 0 43) ; "That won't help clear up the infection in the wound."
					)
				)
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance distanceInMouth of EcoFeature
	(properties
		onMeCheck 4096
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(not (gCurRoom script:))
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(or
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
				)
				(self onMe: event)
			)
			(EcoNarrator init: 3 0 0 17) ; "Adam doesn't need to go down the whale's throat. This is EcoQuest, not Pinocchio! He wonders briefly if the whale has any ambergris in its stomach."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 17) ; "Adam doesn't need to go down the whale's throat. This is EcoQuest, not Pinocchio! He wonders briefly if the whale has any ambergris in its stomach."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance teeth of EcoFeature
	(properties
		onMeCheck 8192
		lookStr 6
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 9) ; Do, ???
			(EcoNarrator init: 3 0 0 26) ; "Cetus doesn't need a dentist, he needs someone to fix the harpoon wound."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance harpoonHead of EcoActor
	(properties
		x 124
		y 65
		sightAngle 45
		approachX 157
		approachY 154
		yStep 4
		view 641
		loop 3
		priority 1
		signal 18448
		cycleSpeed 5
		xStep 5
		moveSpeed 5
	)
)

(instance mouthFeature of EcoFeature
	(properties
		onMeCheck 64
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(1 ; Look
				(if (and (IsFlag 85) (not (IsFlag 88)))
					(EcoNarrator init: 3 0 0 33) ; "Cetus is too weak to do anything further. His struggles are nearly at an end."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(if (not (IsFlag 86))
					(EcoNarrator init: 3 0 0 39) ; "The back of the whale's mouth is closed here. Adam will have to get further away from the whale if he wants to get in Cetus' mouth."
				else
					(EcoNarrator init: 3 0 0 51) ; "That won't help Adam get into Cetus' mouth."
				)
			)
			(44 ; Inventory
				(if (not (IsFlag 86))
					(if (== temp0 29)
						(EcoNarrator init: 3 0 0 50) ; "There's a much simpler way to get into Cetus' mouth. Swim further away."
					else
						(EcoNarrator init: 3 0 0 51) ; "That won't help Adam get into Cetus' mouth."
					)
				else
					(EcoNarrator init: 3 0 0 52) ; "Adam doesn't need to get back into Cetus' mouth now that the harpoon head has been removed."
				)
			)
			(else
				(upperWhale doVerb: theVerb temp0 &rest)
			)
		)
	)
)

(instance outsideOfMouth of EcoFeature
	(properties
		onMeCheck 2
		lookStr 53
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (OneOf theVerb 1 4 6 2 3 7 8)) ; Look, Do, Recycle, Talk, Walk, ???, ???
			(= temp0 theVerb)
			(= theVerb 44) ; Inventory
		)
		(switch theVerb
			(4 ; Do
				(EcoNarrator init: 3 0 0 54) ; "From here, Adam can only perform actions on the whale's mouth."
			)
			(44 ; Inventory
				(EcoNarrator init: 3 0 0 54) ; "From here, Adam can only perform actions on the whale's mouth."
			)
			(else
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)

