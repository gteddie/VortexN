USE [Vortex]
GO

/****** Object:  Table [dbo].[User]    Script Date: 2022/12/26 ¤U¤È 08:31:47 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO
/*Admin Table*/
CREATE TABLE [dbo].[Admin](
	[admin_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[admin_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/*User table */
CREATE TABLE [dbo].[User](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](max) NOT NULL ,
	[password] [nvarchar](max) NOT NULL,
	[email] [nvarchar](max) NULL,
	[image] [nvarchar](max) NULL,
	[registration_date] [date] NOT NULL,
	[gender] [nchar](10) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

/* Game Table */
CREATE TABLE [dbo].[Game](
	[game_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NOT NULL,
	[type] [nvarchar](max) NULL,
	[release_date] [date] NULL,
	[intro] [nvarchar](max) NULL,
	[adult] [nchar](10) NULL,
	[developer_id] [int] NULL,
 CONSTRAINT [PK_Game] PRIMARY KEY CLUSTERED 
(
	[game_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[Game]  WITH CHECK ADD  CONSTRAINT [FK_Game_GameDeveloper] FOREIGN KEY([developer_id])
REFERENCES [dbo].[GameDeveloper] ([developer_id])
GO

ALTER TABLE [dbo].[Game] CHECK CONSTRAINT [FK_Game_GameDeveloper]
GO

/*GameDeveloper Table */
CREATE TABLE [dbo].[GameDeveloper](
	[developer_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NOT NULL,
	[url] [nvarchar](max) NULL,
 CONSTRAINT [PK_GameDeveloper] PRIMARY KEY CLUSTERED 
(
	[developer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/*GameMedia Table */
CREATE TABLE [dbo].[GameMedia](
	[media_id] [int] IDENTITY(1,1) NOT NULL,
	[resource] [nvarchar](max) NOT NULL,
	[resource_type] [nvarchar](max) NULL,
	[game_id] [int] NULL,
 CONSTRAINT [PK_GameMedia] PRIMARY KEY CLUSTERED 
(
	[media_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[GameMedia]  WITH CHECK ADD  CONSTRAINT [FK_GameMedia_Game] FOREIGN KEY([game_id])
REFERENCES [dbo].[Game] ([game_id])
GO

ALTER TABLE [dbo].[GameMedia] CHECK CONSTRAINT [FK_GameMedia_Game]
GO

/*Tag Table */
CREATE TABLE [dbo].[Tag](
	[tag_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NOT NULL,
	[type] [nvarchar](max) NULL,
 CONSTRAINT [PK_GameTag] PRIMARY KEY CLUSTERED 
(
	[tag_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/*GameTag Table */
CREATE TABLE [dbo].[GameTag](
	[game_id] [int] NOT NULL,
	[tag_id] [int] NOT NULL,
 CONSTRAINT [PK_GameTag_1] PRIMARY KEY CLUSTERED 
(
	[game_id] ASC,
	[tag_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[GameTag]  WITH CHECK ADD  CONSTRAINT [FK_GameTag_Game] FOREIGN KEY([game_id])
REFERENCES [dbo].[Game] ([game_id])
GO

ALTER TABLE [dbo].[GameTag] CHECK CONSTRAINT [FK_GameTag_Game]
GO

ALTER TABLE [dbo].[GameTag]  WITH CHECK ADD  CONSTRAINT [FK_GameTag_Tag] FOREIGN KEY([tag_id])
REFERENCES [dbo].[Tag] ([tag_id])
GO

ALTER TABLE [dbo].[GameTag] CHECK CONSTRAINT [FK_GameTag_Tag]
GO
/*Purchase Table */
CREATE TABLE [dbo].[Purchase](
	[purchase_id] [int] IDENTITY(1,1) NOT NULL,
	[purchase_date] [date] NULL,
	[amount] [int] NOT NULL,
	[game_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
 CONSTRAINT [PK_Purchase] PRIMARY KEY CLUSTERED 
(
	[purchase_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Purchase]  WITH CHECK ADD  CONSTRAINT [FK_Purchase_Game] FOREIGN KEY([game_id])
REFERENCES [dbo].[Game] ([game_id])
GO

ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [FK_Purchase_Game]
GO

ALTER TABLE [dbo].[Purchase]  WITH CHECK ADD  CONSTRAINT [FK_Purchase_User] FOREIGN KEY([user_id])
REFERENCES [dbo].[User] ([user_id])
GO

ALTER TABLE [dbo].[Purchase] CHECK CONSTRAINT [FK_Purchase_User]
GO
/*ShoppingCart Table */
CREATE TABLE [dbo].[ShoppingCart](
	[user_id] [int] NOT NULL,
	[game_id] [int] NOT NULL,
	[amount] [int] NOT NULL,
 CONSTRAINT [PK_ShoppingCart] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[game_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[ShoppingCart]  WITH CHECK ADD  CONSTRAINT [FK_ShoppingCart_Game] FOREIGN KEY([game_id])
REFERENCES [dbo].[Game] ([game_id])
GO

ALTER TABLE [dbo].[ShoppingCart] CHECK CONSTRAINT [FK_ShoppingCart_Game]
GO

ALTER TABLE [dbo].[ShoppingCart]  WITH CHECK ADD  CONSTRAINT [FK_ShoppingCart_User] FOREIGN KEY([user_id])
REFERENCES [dbo].[User] ([user_id])
GO

ALTER TABLE [dbo].[ShoppingCart] CHECK CONSTRAINT [FK_ShoppingCart_User]
GO
/*GameItemPrice Table*/
CREATE TABLE [dbo].[GameItemPrice](
	[item_id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](max) NOT NULL,
	[price] [int] NULL,
	[discount_id] [int] NULL,
	[game_id] [int] NOT NULL,
 CONSTRAINT [PK_GameItemPrice] PRIMARY KEY CLUSTERED 
(
	[item_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[GameItemPrice]  WITH CHECK ADD  CONSTRAINT [FK_GameItemPrice_Discount] FOREIGN KEY([discount_id])
REFERENCES [dbo].[Discount] ([discount_id])
GO

ALTER TABLE [dbo].[GameItemPrice] CHECK CONSTRAINT [FK_GameItemPrice_Discount]
GO

ALTER TABLE [dbo].[GameItemPrice]  WITH CHECK ADD  CONSTRAINT [FK_GameItemPrice_Game] FOREIGN KEY([game_id])
REFERENCES [dbo].[Game] ([game_id])
GO

ALTER TABLE [dbo].[GameItemPrice] CHECK CONSTRAINT [FK_GameItemPrice_Game]
GO
/*Discount Table */
CREATE TABLE [dbo].[Discount](
	[discount_id] [int] IDENTITY(1,1) NOT NULL,
	[amount] [int] NULL,
	[start_date] [date] NULL,
	[end_date] [date] NULL,
 CONSTRAINT [PK_Discount] PRIMARY KEY CLUSTERED 
(
	[discount_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/*UserGameTag Table */
CREATE TABLE [dbo].[UserGameTag](
	[uesr_id] [int] NOT NULL,
	[tag_id] [int] NOT NULL,
	[game_id] [int] NOT NULL,
 CONSTRAINT [PK_UserGameTag] PRIMARY KEY CLUSTERED 
(
	[uesr_id] ASC,
	[game_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[UserGameTag]  WITH CHECK ADD  CONSTRAINT [FK_UserGameTag_Game] FOREIGN KEY([game_id])
REFERENCES [dbo].[Game] ([game_id])
GO

ALTER TABLE [dbo].[UserGameTag] CHECK CONSTRAINT [FK_UserGameTag_Game]
GO

ALTER TABLE [dbo].[UserGameTag]  WITH CHECK ADD  CONSTRAINT [FK_UserGameTag_Tag] FOREIGN KEY([tag_id])
REFERENCES [dbo].[Tag] ([tag_id])
GO

ALTER TABLE [dbo].[UserGameTag] CHECK CONSTRAINT [FK_UserGameTag_Tag]
GO

ALTER TABLE [dbo].[UserGameTag]  WITH CHECK ADD  CONSTRAINT [FK_UserGameTag_User] FOREIGN KEY([uesr_id])
REFERENCES [dbo].[User] ([user_id])
GO

ALTER TABLE [dbo].[UserGameTag] CHECK CONSTRAINT [FK_UserGameTag_User]
GO
/*Comment Table */
CREATE TABLE [dbo].[Comment](
	[comment_id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](max) NOT NULL,
	[text] [nvarchar](max) NOT NULL,
	[recommend] [nchar](10) NULL,
	[date] [date] NOT NULL,
	[trusted] [nchar](10) NULL,
	[interesting] [nchar](10) NULL,
	[user_id] [int] NOT NULL,
	[game_id] [int] NOT NULL,
 CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED 
(
	[comment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_Game] FOREIGN KEY([game_id])
REFERENCES [dbo].[Game] ([game_id])
GO

ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_Game]
GO

ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_User] FOREIGN KEY([user_id])
REFERENCES [dbo].[User] ([user_id])
GO

ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_User]
GO
/* CommentScore */
CREATE TABLE [dbo].[Comment](
	[comment_id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](max) NOT NULL,
	[text] [nvarchar](max) NOT NULL,
	[recommend] [nchar](10) NULL,
	[date] [date] NOT NULL,
	[trusted] [nchar](10) NULL,
	[interesting] [nchar](10) NULL,
	[user_id] [int] NOT NULL,
	[game_id] [int] NOT NULL,
 CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED 
(
	[comment_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_User] FOREIGN KEY([user_id])
REFERENCES [dbo].[User] ([user_id])
GO

ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_User]
GO