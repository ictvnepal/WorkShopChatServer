/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pchat.data.object;

/**
 *
 * @author Sun-J
 */
public enum CommandType {
    LOGIN,
    LOGOUT,
    GET_ROOM_IMAGE,
    GET_AVATAR_IMAGE,
    GET_MEMBER_TYPE,
    MOVEAVATAR,
    GET_ROOM_USERS,
    NEW_ROOM_USER,
    MESSAGE,
    BLOCK_USER,
    UNBLOCK_USER,
    KICK_USER,
    CHANGE_AVATAR,
    AWAY,
    PRIVATE_MESSAGE
}
