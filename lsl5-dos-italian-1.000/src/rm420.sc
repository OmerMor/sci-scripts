;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use LoadMany)
(use Actor)
(use System)

(public
	rm420 0
)

(instance rm420 of LLRoom
	(properties
		picture 420
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 1420 1421)
		(gTheMusic number: 425 loop: -1 flags: 1 play:)
		(self setScript: sRoom)
	)
)

(instance sRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 123)
			)
			(1
				(Say ; "All right, Patti, here's the deal: we're convinced of organized crime's considerable influence in the entertainment industry. I want you to use your musical talent to help us obtain sufficient evidence to convict the guilty parties."
					Inspector_Desmond_IIspettore_Desmond
					420
					0
					108
					139
					self
				)
			)
			(2
				(= ticks 60)
			)
			(3
				(Say You_ITu 420 1 108 139 self) ; "But, Inspector," you say worriedly, "I know nothing of spying."
			)
			(4
				(= ticks 60)
			)
			(5
				(Say ; "Don't worry, Patti, most of the spies we use are amateurs! You won't be `licensed to kill!' Just keep your eyes and ears open, learn what you can, take advantage of any opportunities, and try to bring back some hard evidence!"
					Inspector_Desmond_IIspettore_Desmond
					420
					2
					108
					139
					self
				)
			)
			(6
				(= ticks 60)
			)
			(7
				(Say ; "We'll make sure you're in the right place at the right time. And you'll be doing good for your country."
					Inspector_Desmond_IIspettore_Desmond
					420
					3
					108
					139
					self
				)
			)
			(8
				(= ticks 60)
			)
			(9
				(TPrint 420 4) ; "You think, "Not to mention getting even with those bastards for all the times I've been screwed in the past!""
				(= ticks 60)
			)
			(10
				(Say You_ITu 420 5 108 139 self) ; "All right, Inspector Desmond," you say. "But what places and what times?"
			)
			(11
				(= ticks 60)
			)
			(12
				(Say ; "There are two specific areas of concern: one is subliminal messages in popular music. Our studies link the recent nationwide rise in crime to increased popularity of hard rock music."
					Inspector_Desmond_IIspettore_Desmond
					420
					6
					108
					139
					self
				)
			)
			(13
				(= ticks 60)
			)
			(14
				(Say ; "`des Rever Records' in Baltimore is heavily involved in such subliminal recordings. Much of the overdubbing at that studio is handled by a young recording engineer named Reverse Biaz."
					Inspector_Desmond_IIspettore_Desmond
					420
					7
					108
					139
					self
				)
			)
			(15
				(= ticks 60)
			)
			(16
				(Say ; "The second area is the recent flood of obscene rap recordings. I personally believe records like these are being used by the Mob to undermine the moral fiber of our nation's youth."
					Inspector_Desmond_IIspettore_Desmond
					420
					8
					108
					139
					self
				)
			)
			(17
				(= ticks 60)
			)
			(18
				(Say ; "`K-RAP Radio' in Philadelphia is the headquarters of the rap group `2 Live 2 Screw,' who have had an unjustified string of hits recently. I'm sure that place is a center of Mob involvement."
					Inspector_Desmond_IIspettore_Desmond
					420
					9
					108
					139
					self
				)
			)
			(19
				(= ticks 60)
			)
			(20
				(TPrint 420 10) ; ""That's hard to believe," you think."
				(= ticks 60)
			)
			(21
				(Say You_ITu 420 11 108 139 self) ; "But to Desmond you say, "Well, all right, Inspector, but I'm hardly an expert in subliminal recordings or rap music!""
			)
			(22
				(= ticks 60)
			)
			(23
				(Say ; "Oh, don't worry, Patti. With your `talents,' you can easily fake your way through the simplistic noise these guys pass off as music. After all, they're hardly the M.J.Q.!"
					Inspector_Desmond_IIspettore_Desmond
					420
					12
					108
					139
					self
				)
			)
			(24
				(= ticks 60)
			)
			(25
				(Say ; "One more thing: a man we know only as `Julius' has been connected to both these businesses. I think this `Julius' character may be the key to the entire problem."
					Inspector_Desmond_IIspettore_Desmond
					420
					13
					108
					139
					self
				)
			)
			(26
				(= ticks 60)
			)
			(27
				(Say ; "Anything you can discover about `Julius' or K-RAP or des Rever Records would be helpful. We'll provide you with background information on all the pertinent people, places and groups, but it will be up to you to get in and get out with whatever hard facts you can."
					Inspector_Desmond_IIspettore_Desmond
					420
					14
					108
					139
					self
				)
			)
			(28
				(= ticks 60)
			)
			(29
				(Say You_ITu 420 15 108 139 self) ; "Okay, boss, I'm on! Now, how do I begin?"
			)
			(30
				(= ticks 60)
			)
			(31
				(Say ; "Earlier this morning I set you up with a gig at des Rever Records as a keyboard sub on a recording session."
					Inspector_Desmond_IIspettore_Desmond
					420
					16
					108
					139
					self
				)
			)
			(32
				(= ticks 60)
			)
			(33
				(Say ; "We've also arranged a short East Coast tour as your cover story. The government will handle all your travel arrangements."
					Inspector_Desmond_IIspettore_Desmond
					420
					17
					108
					139
					self
				)
			)
			(34
				(= ticks 60)
			)
			(35
				(Say You_ITu 420 18 108 139 self) ; "First class, of course?"
			)
			(36
				(= ticks 60)
			)
			(37
				(Say ; "Yes," he laughs, "first class, of course! I'll get you a private limousine and your own personal driver! And, Patti, if things go well, I'll even set you up with a gig at the White House! Would you like that?"
					Inspector_Desmond_IIspettore_Desmond
					420
					19
					108
					139
					self
				)
			)
			(38
				(= ticks 60)
			)
			(39
				(Say You_ITu 420 20 108 139 self) ; ""Yes, of course!" you agree, afraid now that you're in way over your head."
			)
			(40
				(= ticks 60)
			)
			(41
				(Say ; "Come with me, Patti," Desmond says, rising to his feet, "we'll get started right now!"
					Inspector_Desmond_IIspettore_Desmond
					420
					21
					108
					139
					self
				)
			)
			(42
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gTheMusic fade:)
				(gCurRoom newRoom: 430)
			)
		)
	)
)

(instance Inspector_Desmond_IIspettore_Desmond of Talker
	(properties
		name {Inspector Desmond}
		y 160
		nsTop 29
		nsLeft 115
		view 1420
		loop 3
		talkWidth 200
	)

	(method (init)
		(= bust desmondBust)
		(= mouth desmondMouth)
		(super init: &rest)
	)
)

(instance desmondBust of Prop
	(properties
		view 1420
		loop 1
	)
)

(instance desmondMouth of Prop
	(properties
		nsTop 13
		view 1420
		cycleSpeed 8
	)
)

(instance You_ITu of Talker
	(properties
		name {You}
		x 140
		y 170
		nsTop 59
		nsLeft 199
		view 1421
		loop 3
	)

	(method (init)
		(= mouth pattiMouth)
		(super init: &rest)
	)
)

(instance pattiMouth of Prop
	(properties
		view 1421
		cycleSpeed 8
	)
)

