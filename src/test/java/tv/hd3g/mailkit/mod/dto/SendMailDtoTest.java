/*
 * This file is part of MailKit.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * Copyright (C) hdsdi3g for hd3g.tv 2020
 *
 */
package tv.hd3g.mailkit.mod.dto;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static tv.hd3g.mailkit.tool.DataGenerator.getRandomEnum;
import static tv.hd3g.mailkit.tool.DataGenerator.makeRandomString;
import static tv.hd3g.mailkit.tool.DataGenerator.makeRandomThings;

import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import tv.hd3g.commons.mailkit.SendMailDto;
import tv.hd3g.commons.mailkit.SendMailDto.MessageGrade;

class SendMailDtoTest {

	private SendMailDto sendMailDto;

	private String templateName;
	private String senderAddr;
	private String replyToAddr;
	private MessageGrade grade;
	private String externalReference;
	private String senderReference;

	@Mock
	private Locale lang;
	@Mock
	private Map<String, Object> templateVars;
	@Mock
	private List<String> recipientsAddr;
	@Mock
	private List<String> recipientsCCAddr;
	@Mock
	private List<String> recipientsBCCAddr;
	@Mock
	private SortedSet<File> attachedFiles;
	@Mock
	private Set<String> resourceFiles;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		templateName = makeRandomString();
		senderAddr = makeRandomString();
		replyToAddr = makeRandomString();
		grade = getRandomEnum(MessageGrade.class);
		externalReference = makeRandomString();
		senderReference = makeRandomString();

		sendMailDto = new SendMailDto(templateName, lang, templateVars, senderAddr,
		        recipientsAddr, recipientsCCAddr, recipientsBCCAddr);
	}

	@Test
	void testSendMailDtoStringLocaleMapOfStringObjectStringListOfStringListOfStringListOfString() {
		final var list = makeRandomThings().collect(Collectors.toList());
		final var recipientsAddr = new String[list.size()];
		for (int pos = 0; pos < recipientsAddr.length; pos++) {
			recipientsAddr[pos] = list.get(pos);
		}

		sendMailDto = new SendMailDto(templateName, lang, templateVars, senderAddr, recipientsAddr);
		assertEquals(templateName, sendMailDto.getTemplateName());
		assertEquals(lang, sendMailDto.getLang());
		assertEquals(templateVars, sendMailDto.getTemplateVars());
		assertEquals(senderAddr, sendMailDto.getSenderAddr());

		final var rList = sendMailDto.getRecipientsAddr();
		final var rRecipientsAddr = new String[rList.size()];
		for (int pos = 0; pos < rRecipientsAddr.length; pos++) {
			rRecipientsAddr[pos] = rList.get(pos);
		}
		assertArrayEquals(recipientsAddr, rRecipientsAddr);
	}

	@Test
	void testGetTemplateName() {
		assertEquals(templateName, sendMailDto.getTemplateName());
	}

	@Test
	void testGetLang() {
		assertEquals(lang, sendMailDto.getLang());
	}

	@Test
	void testGetTemplateVars() {
		assertEquals(templateVars, sendMailDto.getTemplateVars());
	}

	@Test
	void testGetSenderAddr() {
		assertEquals(senderAddr, sendMailDto.getSenderAddr());
	}

	@Test
	void testGetRecipientsAddr() {
		assertEquals(recipientsAddr, sendMailDto.getRecipientsAddr());
	}

	@Test
	void testGetRecipientsCCAddr() {
		assertEquals(recipientsCCAddr, sendMailDto.getRecipientsCCAddr());
	}

	@Test
	void testGetRecipientsBCCAddr() {
		assertEquals(recipientsBCCAddr, sendMailDto.getRecipientsBCCAddr());
	}

	@Test
	void testSetGrade() {
		sendMailDto.setGrade(grade);
		assertEquals(grade, sendMailDto.getGrade());
	}

	@Test
	void testGetGrade() {
		assertNull(sendMailDto.getGrade());
	}

	@Test
	void testSetReplyToAddr() {
		sendMailDto.setReplyToAddr(replyToAddr);
		assertEquals(replyToAddr, sendMailDto.getReplyToAddr());
	}

	@Test
	void testGetReplyToAddr() {
		assertNull(sendMailDto.getReplyToAddr());
	}

	@Test
	void testSetSenderReference() {
		sendMailDto.setSenderReference(senderReference);
		assertEquals(senderReference, sendMailDto.getSenderReference());
	}

	@Test
	void testGetSenderReference() {
		assertNull(sendMailDto.getSenderReference());
	}

	@Test
	void testSetExternalReference() {
		sendMailDto.setExternalReference(externalReference);
		assertEquals(externalReference, sendMailDto.getExternalReference());
	}

	@Test
	void testGetExternalReference() {
		assertNull(sendMailDto.getExternalReference());
	}

	@Test
	void testSetAttachedFiles() {
		sendMailDto.setAttachedFiles(attachedFiles);
		assertEquals(attachedFiles, sendMailDto.getAttachedFiles());
	}

	@Test
	void testGetAttachedFiles() {
		assertNull(sendMailDto.getAttachedFiles());
	}

	@Test
	void testSetResourceFiles() {
		sendMailDto.setResourceFiles(resourceFiles);
		assertEquals(resourceFiles, sendMailDto.getResourceFiles());
	}

	@Test
	void testGetResourceFiles() {
		assertNull(sendMailDto.getResourceFiles());
	}

}
