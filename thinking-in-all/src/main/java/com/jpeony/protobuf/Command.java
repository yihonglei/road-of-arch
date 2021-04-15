package com.jpeony.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

public final class Command {
  private static Descriptors.FileDescriptor descriptor;
  
  public static void registerAllExtensions(ExtensionRegistryLite registry) {}
  
  public static void registerAllExtensions(ExtensionRegistry registry) {
    registerAllExtensions((ExtensionRegistryLite)registry);
  }
  
  public enum CommandType implements ProtocolMessageEnum {
    AUTH(1),
    PING(2),
    PONG(3),
    UPLOAD_DATA(4),
    PUSH_DATA(5),
    AUTH_BACK(11),
    UPLOAD_DATA_BACK(14),
    PUSH_DATA_BACK(15),
    PATH(21),
    DOUBLE_FLASH(31),
    WHISTLE(32),
    UNLOCK(33),
    OPEN_DOOR(34),
    CHANGE_IP(35);
    
    public static final int AUTH_VALUE = 1;
    
    public static final int PING_VALUE = 2;
    
    public static final int PONG_VALUE = 3;
    
    public static final int UPLOAD_DATA_VALUE = 4;
    
    public static final int PUSH_DATA_VALUE = 5;
    
    public static final int AUTH_BACK_VALUE = 11;
    
    public static final int UPLOAD_DATA_BACK_VALUE = 14;
    
    public static final int PUSH_DATA_BACK_VALUE = 15;
    
    public static final int PATH_VALUE = 21;
    
    public static final int DOUBLE_FLASH_VALUE = 31;
    
    public static final int WHISTLE_VALUE = 32;
    
    public static final int UNLOCK_VALUE = 33;
    
    public static final int OPEN_DOOR_VALUE = 34;
    
    public static final int CHANGE_IP_VALUE = 35;
    
    private static final Internal.EnumLiteMap<CommandType> internalValueMap = new Internal.EnumLiteMap<CommandType>() {
        @Override
        public Command.CommandType findValueByNumber(int number) {
          return Command.CommandType.forNumber(number);
        }
      };
    
    private static final CommandType[] VALUES = values();
    
    private final int value;
    
    @Override
    public final int getNumber() {
      return this.value;
    }
    
    public static CommandType forNumber(int value) {
      switch (value) {
        case 1:
          return AUTH;
        case 2:
          return PING;
        case 3:
          return PONG;
        case 4:
          return UPLOAD_DATA;
        case 5:
          return PUSH_DATA;
        case 11:
          return AUTH_BACK;
        case 14:
          return UPLOAD_DATA_BACK;
        case 15:
          return PUSH_DATA_BACK;
        case 21:
          return PATH;
        case 31:
          return DOUBLE_FLASH;
        case 32:
          return WHISTLE;
        case 33:
          return UNLOCK;
        case 34:
          return OPEN_DOOR;
        case 35:
          return CHANGE_IP;
      } 
      return null;
    }
    
    public static Internal.EnumLiteMap<CommandType> internalGetValueMap() {
      return internalValueMap;
    }
    
    static {
    
    }
    
    @Override
    public final Descriptors.EnumValueDescriptor getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    
    @Override
    public final Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }
    
    public static final Descriptors.EnumDescriptor getDescriptor() {
      return Command.getDescriptor().getEnumTypes().get(0);
    }
    
    CommandType(int value) {
      this.value = value;
    }
  }
  
  public static Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }
  
  static {
    String[] descriptorData = { "\n\rCommand.proto\022\027cn.myzf.common.protobuf*\001\n\013CommandType\022\b\n\004AUTH\020\001\022\b\n\004PING\020\002\022\b\n\004PONG\020\003\022\017\n\013UPLOAD_DATA\020\004\022\r\n\tPUSH_DATA\020\005\022\r\n\tAUTH_BACK\020\013\022\024\n\020UPLOAD_DATA_BACK\020\016\022\022\n\016PUSH_DATA_BACK\020\017\022\b\n\004PATH\020\025\022\020\n\fDOUBLE_FLASH\020\037\022\013\n\007WHISTLE\020 \022\n\n\006UNLOCK\020!\022\r\n\tOPEN_DOOR\020\"\022\r\n\tCHANGE_IP\020#" };
    Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        @Override
        public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
          Command.descriptor = root;
          return null;
        }
      };
    Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
  }
}
